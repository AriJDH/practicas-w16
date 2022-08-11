package com.bootcamp.be_java_hisp_w16_g08_bracco.service;

import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.dto.response.ProductDto;
import com.bootcamp.be_java_hisp_w16_g08_bracco.entiry.Post;
import com.bootcamp.be_java_hisp_w16_g08_bracco.entiry.Product;
import com.bootcamp.be_java_hisp_w16_g08_bracco.entiry.User;
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

}
