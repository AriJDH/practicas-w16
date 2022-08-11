package com.bootcamp.be_java_hisp_w16_g08_gonzalez.service;

import com.bootcamp.be_java_hisp_w16_g08_gonzalez.dto.response.*;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.Post;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.PostPromo;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.Product;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.entity.User;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.exception.NotPromoPostException;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g08_gonzalez.util.MapperProduct;
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
    final
    ModelMapper utilMapper;

    private int postIdCount = 0;
    private int postPromoIdCount = 0;

    public ProductService(IPostRepository postRepository, IUserRepository userRepository){
        User user1 = new User(1,"User1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"User2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user3 = new User(3,"User3",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user4 = new User(4,"User4",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user5 = new User(5,"User5",new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);
        userRepository.addUser(user4);
        userRepository.addUser(user5);

        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.utilMapper = new ModelMapper();
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

    private User getUserIfExist(int idUser) {
        if (!userRepository.isPresent(idUser)) {
            throw new UserNotFoundException();
        }
        return userRepository.getUserById(idUser);
    }

    @Override
    public void publishPostPromo (PostPromoDTO postPromo){
        User postPromoUser = getUserIfExist(postPromo.getUserId());
        postIdCount++;
        ProductDto pDto = postPromo.getProduct();
        Product asociatedProduct = new Product(pDto.getProductId(),pDto.getProductName(),
                pDto.getType(),pDto.getBrand(),pDto.getColor(),pDto.getNotes());

        PostPromo newPostPromo = new PostPromo(postIdCount,postPromoUser,postPromo.getDate(),postPromo.getCategory(),postPromo.getPrice(),asociatedProduct, postPromo.isHasPromo(), postPromo.getDiscount());
        postPromoUser.getPostPromoMade().add(newPostPromo);
        postRepository.addPostPromo(newPostPromo);
    }

    public PostPromoCounterDTO getProductsInPromo (int id){
        User usuario = getUserIfExist(id);
        return new PostPromoCounterDTO(usuario.getUserId(), usuario.getName(), usuario.getPostPromoMade().size());
    }

    @Override
    public ResponseProductPromoDTO getAllProductsInPromo (int id){

        User usuario = getUserIfExist(id);
        if(usuario.getPostPromoMade().size()<1){
            throw new NotPromoPostException();
        }

        List<PostPromoDTO> promoPosts = usuario.getPostPromoMade().stream()
                .map(x->utilMapper.map(x,PostPromoDTO.class))
                .collect(Collectors.toList());

        return new ResponseProductPromoDTO(usuario.getUserId(), usuario.getName(), promoPosts);
    }

}
