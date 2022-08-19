package com.bootcamp.be_java_hisp_w16_g01.controllers;

import com.bootcamp.be_java_hisp_w16_g01.controller.PostController;
import com.bootcamp.be_java_hisp_w16_g01.dto.response.FollowedPostsDto;
import com.bootcamp.be_java_hisp_w16_g01.service.IPostService;
import com.bootcamp.be_java_hisp_w16_g01.utils.DataFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PostControllerTest {

    @Mock
    IPostService postService;

    @InjectMocks
    PostController controller;

    @Test
    @DisplayName("getFollowedPostsOrder - Publicaciones de las ultimas 2 semanas")
    public void getFollowedPostsTest(){

        //Arrange
        Integer userId = 1;
        String order = "date_asc";

        FollowedPostsDto response = DataFactory.generateGetFollowedPostsControllerTestResponse(userId);

        when(postService.getFollowedPosts(userId, order)).thenReturn(response);

        //Act
        //Assert
        assertEquals(response, controller.getFollowedPostsOrder(userId, order).getBody());
        verify(postService, Mockito.atLeastOnce()).getFollowedPosts(userId, order);
    }
}
