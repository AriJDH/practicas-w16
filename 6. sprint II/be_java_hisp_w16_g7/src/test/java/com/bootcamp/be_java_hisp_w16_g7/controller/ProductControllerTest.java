package com.bootcamp.be_java_hisp_w16_g7.controller;

import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7.service.IProductService;
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

        ResponsePostDTO expectedPost = new ResponsePostDTO(2222, 1234, LocalDate.of(2022, 8, 10), new ProductDTO(), 99, 1000.0);
        RecentPostsDTO expected = new RecentPostsDTO(1111, List.of(expectedPost) );

        when(productService.recentPost(1111, "date_asc")).thenReturn(expected);

        //Act
        var response=productController.recentPost(1111, "date_asc");


        //Assert
        assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

}