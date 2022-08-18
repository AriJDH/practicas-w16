package com.bootcamp.be_java_hisp_w16_g08_negreyra.service;

import com.bootcamp.be_java_hisp_w16_g08_negreyra.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.Post;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.Product;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.PromoProductPost;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.entiry.User;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.exception.UserNotVendorException;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g08_negreyra.util.MapperProduct;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService{

    final
    IPostRepository postRepository;
    final
    IUserRepository userRepository;

    ModelMapper mapper = new ModelMapper();
    private int postIdCount = 0;

    public ProductService(IPostRepository postRepository, IUserRepository userRepository){
        User user1 = new User(1,"User1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"User2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user3 = new User(3,"User3",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user4 = new User(4,"User4",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user5 = new User(5,"User5",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        userRepository.addUser(user4);
        userRepository.addUser(user5);

        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }
    @Override
    public void publishPost(PostDto post){
        User postUser = getUserIfExist(post.getUserId());
        postIdCount++;
        ProductDto pDto = post.getProduct();
        Product asociatedProduct = new Product(pDto.getProductId(),pDto.getProductName(),
                                                pDto.getType(),pDto.getBrand(),pDto.getColor(),pDto.getNotes());

        Post newPost = new Post(postIdCount,postUser,post.getDate(),post.getCategory(),post.getPrice(),asociatedProduct);
        postUser.getPostMade().add(newPost);
        postRepository.addPost(newPost);
    }

    @Override
    public void publishDiscountPost(PromoProductPostDto ProdDiscDto) {
        User postUser = getUserIfExist(ProdDiscDto.getUserId());
        postIdCount++;
        ProductDto ProdDto = ProdDiscDto.getProduct();
        Product asociatedProduct = new Product(ProdDto.getProductId(),ProdDto.getProductName(),
                ProdDto.getType(),ProdDto.getBrand(),ProdDto.getColor(),ProdDto.getNotes());

        Post newDisountPost = new PromoProductPost(postIdCount,postUser, ProdDiscDto.getDate(), ProdDiscDto.getCategory(), ProdDiscDto.getPrice(),asociatedProduct,ProdDiscDto.isHasPromo(),ProdDiscDto.getDiscount());
        postUser.getPostMade().add(newDisountPost);
        postRepository.addPost(newDisountPost);
    }

    @Override
    public PromoPostAmmountDto getPromoPostAmmount(int userId) {
        User user = getUserIfExist(userId);
        if (!isVendor(user)) {
            throw new UserNotVendorException();
        }
        int followersCount = (int) user.getPostMade().stream().filter(x->x instanceof PromoProductPost).count();
        return new PromoPostAmmountDto(user.getUserId(), user.getName(), followersCount);
    }

    public boolean isVendor(User user) {
        return user.getPostMade().size() > 0;
    }
    private User getUserIfExist(int idUser) {
        if (!userRepository.isPresent(idUser)) {
            throw new UserNotFoundException();
        }
        return userRepository.getUserById(idUser);
    }

    public PromoPostOfUserDto ListPromoPostOfVendor(int vendorId){
        User user = getUserIfExist(vendorId);
        if (!isVendor(user)) {
            throw new UserNotVendorException();
        }

        List<PromoProductPostDto> discountPostMade = user.getPostMade().stream()
                .filter(x->x instanceof PromoProductPost).map(x->mapper.map(x,PromoProductPostDto.class)).collect(Collectors.toList());

        return new PromoPostOfUserDto(user.getUserId(),user.getName(),discountPostMade);
    }

}
