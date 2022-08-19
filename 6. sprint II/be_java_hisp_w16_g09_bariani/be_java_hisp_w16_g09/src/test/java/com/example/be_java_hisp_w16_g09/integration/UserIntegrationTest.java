package com.example.be_java_hisp_w16_g09.integration;

import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.UserFollowedDto;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import static com.example.be_java_hisp_w16_g09.util.PostsUtility.createPostWithInvalidUserId1ValidProduct;
import static com.example.be_java_hisp_w16_g09.util.UsersUtility.getUserFollowedDtoForUserId1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
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
    void getFollowingUsersFromUserId() throws Exception {
        int userId = 1;
        UserFollowedDto mockUserFollowedDto = getUserFollowedDtoForUserId1();
        String expectedDtoResponse = writer.writeValueAsString(mockUserFollowedDto);

        MvcResult response = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedDtoResponse, response.getResponse().getContentAsString());
    }
}
