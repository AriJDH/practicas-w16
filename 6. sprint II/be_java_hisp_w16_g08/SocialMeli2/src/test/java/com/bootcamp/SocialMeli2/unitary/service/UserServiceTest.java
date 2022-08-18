package com.bootcamp.SocialMeli2.unitary.service;

import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.service.ProductService;
import com.bootcamp.SocialMeli2.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @Mock
    IPostRepository postRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addFollower() {
    }

    @Test
    void getUserFollowerCount() {
    }

    @Test
    void unfollowUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getVendorsFollowedByUser() {
    }

    @Test
    void isVendor() {
    }

    @Test
    void getAllVendorFollowers() {
    }

    @Test
    void getPostFromFollowed() {
    }

    @Test
    void orderPostList() {
    }
}