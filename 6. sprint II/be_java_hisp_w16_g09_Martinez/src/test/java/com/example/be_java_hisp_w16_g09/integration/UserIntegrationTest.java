package com.example.be_java_hisp_w16_g09.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetFollowersCount() throws Exception {

                this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "3"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Juan"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0));



    }

    @Test
    public void getFollowersListOfUser() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",2))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Nicolas"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Ricardo"));

    }

    @Test
    public void getFollowedListOfUser() throws  Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",3))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Juan"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.following[0].user_id").value("2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.following[0].user_name").value("Nicolas"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.following[1].user_id").value("4"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.following[1].user_name").value("Pedro"));

    }

    

    @Test
    void unfollowUserTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "1","2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User 1 unfollow 2"));


    }


}
