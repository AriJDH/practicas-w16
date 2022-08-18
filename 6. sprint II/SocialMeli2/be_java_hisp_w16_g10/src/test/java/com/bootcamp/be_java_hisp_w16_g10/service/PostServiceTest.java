package com.bootcamp.be_java_hisp_w16_g10.service;

import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    UserService userService;
    @Mock
    PostRepository postRepository;
    @InjectMocks
    PostService postService;

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findByUserId() {
    }

    @Test
    void save() {
    }

    @Test
    void listFollowersPosts() {
    }
}