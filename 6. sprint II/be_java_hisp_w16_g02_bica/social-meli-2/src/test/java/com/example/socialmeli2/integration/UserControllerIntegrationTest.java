package com.example.socialmeli2.integration;

import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.Product;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.repository.UserRepository;
import com.example.socialmeli2.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void initData(){
        UserRepository userRepository = new UserRepository();
    }

    @Test
    public void addFollowerTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","3", "4"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult);
    }
    @Test
    public void addFollowerExceptionTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","1", "2"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario 1 ya sigue al usuario 2."))
                .andReturn();

        System.out.println(mvcResult);
    }
    @Test
    public void addFollowerSameUserExceptionTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","1", "1"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no puede seguirse a si mismo."))
                .andReturn();

        System.out.println(mvcResult);
    }

    @Test
    public void removeFollowerTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}","1", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(mvcResult);
    }

    @Test
    public void removeFollowerNotFollowingTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}","1", "3"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        System.out.println(mvcResult);
    }


}