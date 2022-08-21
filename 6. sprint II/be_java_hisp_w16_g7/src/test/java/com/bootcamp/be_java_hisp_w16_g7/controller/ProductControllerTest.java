package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.*;
import com.bootcamp.be_java_hisp_w16_g7.service.IProductService;
import com.bootcamp.be_java_hisp_w16_g7.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    @Mock
    IProductService productService;

    @InjectMocks
    ProductController productController;


    //Test

    @Test
    public void testThatRecentPostAreFromLastTwoWeek() {

        //Arrange

        RecentPostsDTO expected = TestUtil.createRecentPostsDTO();

        when(productService.recentPost(1111, "date_asc")).thenReturn(expected);

        //Act
        var response=productController.recentPost(1111, "date_asc");


        //Assert
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), expected);
    }

    @Test
    public void testCreatePost(){

        //Arrange
        PostDTO postDTO = TestUtil.createPostDto();
        ApiResponseDto apiResponseDto = new ApiResponseDto("Post created successfully", "Post of user with id: 111 was created successfully");
        when(productService.createPost(postDTO)).thenReturn(apiResponseDto);

        //Act
        var response = productController.createPost(postDTO);

        //Assert
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), apiResponseDto);

    }

}