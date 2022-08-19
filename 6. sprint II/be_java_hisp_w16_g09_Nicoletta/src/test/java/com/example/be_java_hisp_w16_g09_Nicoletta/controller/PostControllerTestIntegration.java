package com.example.be_java_hisp_w16_g09_Nicoletta.controller;

import com.example.be_java_hisp_w16_g09_Nicoletta.dto.PostDto;
import com.example.be_java_hisp_w16_g09_Nicoletta.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTestIntegration {

    private String payloadJson;
    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    public void setUp(){
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    void createPostTest() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setUserId(1);
        postDto.setDate(LocalDate.now());
        postDto.setCategoryId(100);
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Musculosa");
        productDto.setProductId(1);
        productDto.setColor("Negro");
        productDto.setType("Largo");
        productDto.setNotes("Largo feo");
        productDto.setBrand("1");
        postDto.setProduct(productDto);
        postDto.setPostId(1);
        postDto.setPrice(100);
        payloadJson = (writer).writeValueAsString(postDto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andExpect(status().isOk());
    }
    @Test
    void createPostExceptionDate() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setUserId(1);
        postDto.setDate(LocalDate.now().plusDays(30));
        postDto.setCategoryId(100);
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Musculosa");
        productDto.setProductId(1);
        productDto.setColor("Negro");
        productDto.setType("Largo");
        productDto.setNotes("Largo feo");
        productDto.setBrand("1");
        postDto.setProduct(productDto);
        postDto.setPostId(1);
        postDto.setPrice(100);
        payloadJson = (writer).writeValueAsString(postDto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Invalid date: "+postDto.getDate()));
    }
    @Test
    void createPostExceptionUserTest() throws Exception {
        PostDto postDto = new PostDto();
        postDto.setUserId(10000);
        postDto.setDate(LocalDate.now());
        postDto.setCategoryId(100);
        ProductDto productDto = new ProductDto();
        productDto.setProductName("Musculosa");
        productDto.setProductId(1);
        productDto.setColor("Negro");
        productDto.setType("Largo");
        productDto.setNotes("Largo feo");
        productDto.setBrand("1");
        postDto.setProduct(productDto);
        postDto.setPostId(1);
        postDto.setPrice(100);
        payloadJson = (writer).writeValueAsString(postDto);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User with id: "+postDto.getUserId()+" not found"));
    }
}