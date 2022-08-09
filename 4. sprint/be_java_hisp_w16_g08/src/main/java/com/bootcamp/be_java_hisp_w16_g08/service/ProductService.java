package com.bootcamp.be_java_hisp_w16_g08.service;

import com.bootcamp.be_java_hisp_w16_g08.entiry.Post;
import com.bootcamp.be_java_hisp_w16_g08.entiry.Product;
import com.bootcamp.be_java_hisp_w16_g08.entiry.User;
import com.bootcamp.be_java_hisp_w16_g08.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w16_g08.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g08.repository.PostRepository;
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

    public ProductService(IPostRepository postRepository, IUserRepository userRepository){
        User user1 = new User(1,"User1",new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"User2",new ArrayList<>(),new ArrayList<>());
        User user3 = new User(3,"User3",new ArrayList<>(),new ArrayList<>());

        userRepository.addUser(user1);
        userRepository.addUser(user2);
        userRepository.addUser(user3);

        Post post1 = new Post(1,user1, LocalDate.now(),100,120,new Product(1,"Silla Gamer","Gamer","Razer","black","High end"));
        Post post2 = new Post(2,user1, LocalDate.of(2022,06,05),101,200,new Product(2,"Mouse","Gamer","Logitech","black",""));
        Post post3 = new Post(3,user1, LocalDate.now(),103,300,new Product(3,"Notebook","Gamer","Asus","black",""));

        postRepository.addPost(post1);
        postRepository.addPost(post2);
        postRepository.addPost(post3);
        this.postRepository = postRepository;
        this.userRepository = userRepository;


    }
}
