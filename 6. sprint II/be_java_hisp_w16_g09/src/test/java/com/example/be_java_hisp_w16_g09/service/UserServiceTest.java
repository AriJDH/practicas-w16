package com.example.be_java_hisp_w16_g09.service;

import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.repository.IUserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    @Mock
    IUserRepository userRepository;
    @Mock
    IPostRepository postRepository;

    @InjectMocks
    IUserService userService;

    @Test
    void followUser() {
    }

    @Test
    void getUsersFollowedBySellers() {
    }

    @Test
    void followerCount() {
    }

    @Test
    void unfollow() {
    }

    @Test
    void orderByName() {
    }

    @Test
    void orderByNameFollowed() {
    }

    @Test
    void getAllFollowers() {
    }
}