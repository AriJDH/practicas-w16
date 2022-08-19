package com.bootcamp.be_java_hisp_w16_g7.integration;


import com.bootcamp.be_java_hisp_w16_g7.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;


    static ObjectWriter writer;
    @BeforeAll
    static void setUp(){
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
    }
    @Test
    void createPostIntegrationTest() throws Exception{
        //Arrange
        ProductDTO productDTO = new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nueva");
        PostDTO payloadDTO = new PostDTO(2222, LocalDate.parse("2022-08-19"),productDTO,111,12312.0);

        ApiResponseDto responseDTO = new ApiResponseDto("Post created successfully", "Post of user with id: " + 2222 + " was created successfully");

        String payloadJson = writer.writeValueAsString(payloadDTO);
        String responseJson = writer.writeValueAsString(responseDTO);

        //Act
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        //Assert
        Assertions.assertEquals(responseJson,response.getResponse().getContentAsString());
    }

    @Test
    void followersCountIntegrationTest() throws Exception{
        //Arrange
        FollowersCountDto responseDTO = new FollowersCountDto(4444,"Bob",0);

        String responseJson = writer.writeValueAsString(responseDTO);

        //Act
        MvcResult response =  mockMvc.perform(MockMvcRequestBuilders.get("/users/{userID}/followers/count","4444"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        //Assert
        Assertions.assertEquals(responseJson,response.getResponse().getContentAsString());
    }

    @Test
    void recentPostIntegrationTest() throws Exception{
        //Arrange
        RecentPostsDTO responseDTO= new RecentPostsDTO(1111,new ArrayList<>());

        String responseJson = writer.writeValueAsString(responseDTO);

        //Act
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list","1111")
                        .param("order","date_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        //Assert
        Assertions.assertEquals(responseJson,response.getResponse().getContentAsString());

    }
}
