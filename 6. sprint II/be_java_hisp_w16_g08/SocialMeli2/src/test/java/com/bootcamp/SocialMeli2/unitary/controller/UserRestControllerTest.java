package com.bootcamp.SocialMeli2.unitary.controller;

import com.bootcamp.SocialMeli2.controller.UserRestController;
import com.bootcamp.SocialMeli2.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserRestControllerTest {

    @Mock
    IUserService userService;

    @InjectMocks
    UserRestController userRestController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void followUser() {
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserFollowersCount() {
    }

    @Test
    void unfollowUser() {
    }

    @Test
    void getVendorsFollowedByUser() {
    }

    @Test
    void requestAllFollowers() {
    }

    @Test
    void requestPostFromFollowed() {
    }
}