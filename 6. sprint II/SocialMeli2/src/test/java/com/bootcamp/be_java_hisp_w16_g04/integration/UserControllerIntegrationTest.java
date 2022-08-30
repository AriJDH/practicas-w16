package com.bootcamp.be_java_hisp_w16_g04.integration;

import org.junit.jupiter.api.DisplayName;
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
public class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private final String NAME_RESOURCE = "/users";

    @Test
    @DisplayName("Test devuelve un not found")
    void test1() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(NAME_RESOURCE + "/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    @DisplayName("Test devuelve la cantidad de seguidores")
    void test2() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(NAME_RESOURCE + "/{userId}/followers/count", 100))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(4))
                .andReturn();

    }

    @Test
    @DisplayName("Test devuelve bad request ya usuario lo sigue ")
    void test3() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(NAME_RESOURCE +"/{userId}/follow/{userIdToFollow}",101,100))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The user already follows the seller"))
                .andReturn();
    }

    @Test
    @DisplayName("Test deja seguir ")
    void test4() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post(NAME_RESOURCE +"/{userId}/follow/{userIdToFollow}",100,101))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Successful follow-up"))
                .andReturn();
    }

}
