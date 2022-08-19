package com.example.be_java_hisp_w16_g09.integration;

import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.be_java_hisp_w16_g09.util.PostsUtility.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    MockMvc mockMvc;

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
        PostDto mockPostDTO = createPostWith1ValidProduct();
        String mockPostDTOJson = writer.writeValueAsString(mockPostDTO);
        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockPostDTOJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void createPostWithInvalidDateTest() throws Exception {
        PostDto mockPostDTO = createPostWithInvalidDate1ValidProduct();
        String mockPostDTOJson = writer.writeValueAsString(mockPostDTO);

        MessageDto messageExpectedResponse = new MessageDto("Invalid date: " + mockPostDTO.getDate());
        String messageExpectedResponseJson = writer.writeValueAsString(messageExpectedResponse);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockPostDTOJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(messageExpectedResponseJson, response.getResponse().getContentAsString());
    }

    @Test
    void createPostWithInvalidUserIdTest() throws Exception {
        PostDto mockPostDTO = createPostWithInvalidUserId1ValidProduct();
        String mockPostDTOJson = writer.writeValueAsString(mockPostDTO);

        MessageDto messageExpectedResponse = new MessageDto("User with id: "+mockPostDTO.getUserId()+" not found");
        String messageExpectedResponseJson = writer.writeValueAsString(messageExpectedResponse);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockPostDTOJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(messageExpectedResponseJson, response.getResponse().getContentAsString());
    }

    @Test
    void createPostWithInvalidProductExceptionTest() throws Exception {
        PostDto mockPostDTO = createPostWithInvalidProductNameBlank();
        String mockPostDTOJson = writer.writeValueAsString(mockPostDTO);

        HashMap<String, List<String>> errors = new HashMap<>();
        List<String> errorListExpected = new ArrayList<>();
        errorListExpected.add("The productName cannot be empty.");
        errors.put("product.productName", errorListExpected);
        MessageDto messageExpectedResponse = new MessageDto("There are some fields that don't respect validations", errors);
        String messageExpectedResponseJson = writer.writeValueAsString(messageExpectedResponse);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockPostDTOJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(messageExpectedResponseJson, response.getResponse().getContentAsString());
    }
}
