package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g10.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    @Mock
    PostService postService;
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void follow() {
    }

    @Test
    void unfollow() {
    }

    @Test
    void countFollowers() {
    }

    @Test
    void listFollowers() {
    }

    @Test
    void listFollowed() {
    }
}