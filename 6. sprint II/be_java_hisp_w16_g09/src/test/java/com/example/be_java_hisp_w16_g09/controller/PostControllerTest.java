package com.example.be_java_hisp_w16_g09.controller;

import com.example.be_java_hisp_w16_g09.repository.IPostRepository;
import com.example.be_java_hisp_w16_g09.service.IPostService;
import com.example.be_java_hisp_w16_g09.service.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class PostControllerTest {
    @Mock
    IPostService postService;

    @InjectMocks
    PostController postController;

    @Test
    void createPost() {
    }

    @Test
    void getRecentPostsOfSellersFollowedByUserWith() {
    }
}