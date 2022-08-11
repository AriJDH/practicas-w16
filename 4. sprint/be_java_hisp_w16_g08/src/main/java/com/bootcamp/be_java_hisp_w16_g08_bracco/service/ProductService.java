package com.bootcamp.be_java_hisp_w16_g08_bracco.service;

import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.ProductDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.PromoDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08_bracco.entity.Product;
import com.bootcamp.be_java_hisp_w16_g08_bracco.entity.User;
import com.bootcamp.be_java_hisp_w16_g08_bracco.exception.IncorretPostInformationException;
import com.bootcamp.be_java_hisp_w16_g08_bracco.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08_bracco.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08_bracco.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService implements IProductService{

    final
    IPostRepository postRepository;
    final
    IUserRepository userRepository;

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

        Post newPost = new Post(postIdCount,postUser,post.getDate(),post.getCategory(),post.getPrice(),asociatedProduct,false,0);
        postUser.getPostMade().add(newPost);
        postRepository.addPost(newPost);
    }

    @Override
    public void publishPromoPost(PromoDto promoDto) {
        validatePromoPostDto(promoDto);
        User postUser = getUserIfExist(promoDto.getUserId());
        postIdCount++;
        Product product = new Product(promoDto.getProduct().getProductId(),promoDto.getProduct().getProductName(),
                                        promoDto.getProduct().getType(),promoDto.getProduct().getBrand(),
                                        promoDto.getProduct().getColor(),promoDto.getProduct().getNotes());

        Post post = new Post(postIdCount, postUser,promoDto.getDate(),promoDto.getCategory(),promoDto.getPrice()
                ,product,promoDto.isHasPromo(),promoDto.getDiscount());
        postUser.getPostMade().add(post);
        postRepository.addPost(post);
    }

    private void validatePromoPostDto(PromoDto promoDto){
        validateHasPromoDiscount(promoDto.isHasPromo(),promoDto.getDiscount());
        validateDiscountNotMinorThanZero(promoDto.getDiscount());
    }

    private void validateHasPromoDiscount(boolean hasPromo, double discout){
        if(!hasPromo && discout!=0){
            throw new IncorretPostInformationException();
        }
    }

    private void validateDiscountNotMinorThanZero(double discount){
        if(discount<0){
            throw new IncorretPostInformationException();
        }
    }

    private User getUserIfExist(int idUser) {
        if (!userRepository.isPresent(idUser)) {
            throw new UserNotFoundException();
        }
        return userRepository.getUserById(idUser);
    }

}
