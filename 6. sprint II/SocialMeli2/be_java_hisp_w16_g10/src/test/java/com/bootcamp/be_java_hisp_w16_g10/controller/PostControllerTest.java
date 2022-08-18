package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.service.IPostService;
import com.bootcamp.be_java_hisp_w16_g10.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    @Mock
    private PostService postService;
    @InjectMocks
    private PostController postController;

    @Test
    void US005() {
    }

    @Test
    void US006() {
    }

}