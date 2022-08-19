package com.example.be_java_hisp_w16_g09.util;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.ProductDto;

import java.time.LocalDate;

public class PostsUtility {

    public static PostDto createPostWith1ValidProduct(){
        return new PostDto(1,
                0,
                LocalDate.now(),
                new ProductDto(1, "Product Mock", "Mock Type","Mock Brand", "Black", ""),
                99,
                100.5);
    }
    public static PostDto createPostWithInvalidDate1ValidProduct(){
        return new PostDto(1,
                0,
                LocalDate.now().plusDays(40),
                new ProductDto(1, "Product Mock", "Mock Type","Mock Brand", "Black", ""),
                99,
                100.5);
    }

    public static PostDto createPostWithInvalidUserId1ValidProduct(){
        return new PostDto(7474,
                0,
                LocalDate.now().plusDays(40),
                new ProductDto(1, "Product Mock", "Mock Type","Mock Brand", "Black", ""),
                99,
                100.5);
    }

    public static PostDto createPostWithInvalidProductNameBlank(){
        return new PostDto(1,
                0,
                LocalDate.now(),
                new ProductDto(1, "", "Mock Type","Mock Brand", "Black", ""),
                99,
                100.5);
    }
}
