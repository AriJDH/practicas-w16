package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PostService postService;

    @Test
    public void addPostTest() throws Exception{
        ProductDto producto = new ProductDto(405, "Huawei Mate Book", "5", "Huawei", "grey", "Premium laptop");
        LocalDate fechaPost = LocalDate.of(2021, 10, 19);
        PostDto postDto = new PostDto(1, fechaPost, producto, 50, 550000.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadPostDto = writer.writeValueAsString(postDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadPostDto))
                        .andDo(print())
                        .andExpect(status().isOk());
    }
}
