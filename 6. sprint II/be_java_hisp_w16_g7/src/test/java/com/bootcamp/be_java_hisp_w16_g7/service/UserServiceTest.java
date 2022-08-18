package com.bootcamp.be_java_hisp_w16_g7.service;

import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;


    //Test
    @Test
    public void followUserExists(){
        //arrange
        int id = 1111, idToFollow = 2222;
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        when(userRepository.findUserById(id)).thenReturn(new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        when(userRepository.findUserById(idToFollow)).thenReturn(new User(2222, "Alexander The Great", new ArrayList<>(), new ArrayList<>(), posts));

        //act
        HttpStatus response = userService.follow(id, idToFollow);

        //assert
        assertEquals(response, HttpStatus.OK);
    }

    @Test
    public void followUserNotExists(){
        //arrange
        int id = 1111, idToFollow = 2222;
        List<Post> posts = new ArrayList<>();
        posts.add(new Post());
        when(userRepository.findUserById(id)).thenReturn(new User(1111, "John Doe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        when(userRepository.findUserById(idToFollow)).thenReturn(null);
        //act
        try{
            HttpStatus response = userService.follow(id, idToFollow);
        } catch (Exception e){
            assertEquals(e.getClass(), UserNotFoundException.class);
        }



    }

}