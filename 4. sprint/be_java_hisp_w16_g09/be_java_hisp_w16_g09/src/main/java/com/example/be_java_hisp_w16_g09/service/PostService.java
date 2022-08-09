package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.dto.NewPostDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.exception.UserNotFoundException;
import com.example.be_java_hisp_w16_g09.model.Post;
import com.example.be_java_hisp_w16_g09.model.Product;
import com.example.be_java_hisp_w16_g09.model.User;
import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PostService implements IPostService{
    @Autowired
    IPostRepository postRepository;

    @Autowired
    IUserRepository userRepository;

    //Javi


    //Martin
    public void createPost(NewPostDto postDto){
        Post post = new Post();
        int userId = postDto.getUserId();
        User user = userRepository.searchById(userId);
        if (user == null){
            throw new UserNotFoundException(userId);
        }
        post.setUser(user);
        Product product = new Product(postDto.getProduct().getProductId(), postDto.getProduct().getProductName(),
                postDto.getProduct().getType(), postDto.getProduct().getBrand(), postDto.getProduct().getColor(),
                postDto.getProduct().getNotes());
        post.setProduct(product);
        post.setDate(LocalDate.now());
        post.setCategoryId(postDto.getCategoryId());
        post.setPrice(postDto.getPrice());
        postRepository.createElement(post);
    }

    //MaxiM


    //MaxiN


    //Guille


    //Nico



}
