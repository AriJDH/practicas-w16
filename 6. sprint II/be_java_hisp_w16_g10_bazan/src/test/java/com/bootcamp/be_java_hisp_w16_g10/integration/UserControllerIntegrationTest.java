package com.bootcamp.be_java_hisp_w16_g10.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void listAllUsersTest() throws Exception {

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200,result.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE,result.getResponse().getContentType());
    }

    @Test
    void getFollowersCountTest() throws Exception {//hago que devuelva un 400 porque no es seller y pq no tiene followers

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(400,result.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE,result.getResponse().getContentType());
    }

    @Test
    void getFollowersListTest() throws Exception {

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(400,result.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE,result.getResponse().getContentType());
    }

    @Test
    void getFollowedListTest() throws Exception {

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andReturn();

        assertEquals(200,result.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE,result.getResponse().getContentType());
    }

    @Test
    void followTest() throws Exception {

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(400,result.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE,result.getResponse().getContentType());
    }

    @Test
    void unfollowTest() throws Exception {

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",2,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(400,result.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE,result.getResponse().getContentType());
    }
}
