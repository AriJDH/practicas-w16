package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.dto.response.PostDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.ProductDto;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.UserFollowersList;
import com.bootcamp.be_java_hisp_w16_g08.entiry.Post;
import com.bootcamp.be_java_hisp_w16_g08.entiry.Product;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.bootcamp.be_java_hisp_w16_g08.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g08.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g08.repository.PostRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);

        user1.getFollowedList().add(user2);
        user2.getFollowerList().add(user1);
        user1.getFollowedList().add(user3);
        user3.getFollowerList().add(user1);
        postIdCount++;
        Post post1 = new Post(postIdCount,user1, LocalDate.now(),100,120,new Product(1,"Silla Gamer","Gamer","Razer","black","High end"));
        postIdCount++;
        Post post2 = new Post(postIdCount,user2, LocalDate.of(2022,06,05),101,200,new Product(2,"Mouse","Gamer","Logitech","black",""));
        postIdCount++;
        Post post3 = new Post(postIdCount,user1, LocalDate.now(),103,300,new Product(3,"Notebook","Gamer","Asus","black",""));

        user1.getPostMade().add(post1);
        user2.getPostMade().add(post2);
        user1.getPostMade().add(post3);

        postRepository.addPost(post1);
        postRepository.addPost(post2);
        postRepository.addPost(post3);
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
