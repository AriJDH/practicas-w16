package com.example.be_java_hisp_w16_g09.integration;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.ProductDto;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CreatePostIT {
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
    public void postCreatePostWithInvalidDate() throws Exception{

        LocalDate publicationDate = LocalDate.of(2023, 5, 11);
        ProductDto productDto = new ProductDto(4, "Cafetera", "Electrodomesti", "Oster", "Negro", "");
        PostDto onePostDto = new PostDto(2, 0, publicationDate, productDto, 1, 1);

        String payloadJson = writer.writeValueAsString(onePostDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(String.format("Invalid date: %s",onePostDto.getDate())));
    }

    @Test
    public void postCreatePostWithInvalidUser() throws Exception{

        LocalDate publicationDate = LocalDate.now();
        ProductDto productDto = new ProductDto(4, "Cafetera", "Electrodomesti", "Oster", "Negro", "");
        PostDto onePostDto = new PostDto(999, 0, publicationDate, productDto, 1, 1);

        String payloadJson = writer.writeValueAsString(onePostDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(String.format("User with id: %s not found",onePostDto.getUserId())));
    }
}
