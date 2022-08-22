package com.bootcamp.be_java_hisp_w16_g7.integration;

import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponseUserFollowedDTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTesting {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Verifica que un usuario pueda seguir a un usuario vendedor")
    @Test
    public void testFollowValidSellerUser() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/follow/{userIdToFollow}", 4444, 5555)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Follow user"))
                .andExpect(jsonPath("$.message").value("User with id 4444 has followed user with id 5555"));
    }

    @DisplayName("Verifica que un usuario no pueda seguir a un usuario no vendedor")
    @Test
    public void testFollowNoValidSellerUser() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/follow/{userIdToFollow}", 4444, 3333)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Bad Request"))
                .andExpect(jsonPath("$.message").value("User 3333 is not seller"));
    }

    @DisplayName("Verifica que un usuario no existe")
    @Test
    public void testFollowNoFoundUser() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/follow/{userIdToFollow}", 4444, 33333)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("User Not Found"))
                .andExpect(jsonPath("$.message").value("User with id 33333 not found"));
    }

    @DisplayName("Verifica que un usuario no se pueda seguir asi mismo")
    @Test
    public void testFollowNoValidSameUser() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/follow/{userIdToFollow}", 5555, 5555)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Same user"))
                .andExpect(jsonPath("$.message").value("Both user id (5555) are the same, cannot perform this action"));
    }

    @DisplayName("Verifica que un usuario pueda dejar de seguir a un usuario vendedor")
    @Test
    public void testUnFollowValidSellerUser() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/unfollow/{userIdToUnfollow}", 4444, 5555)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Unfollow user"))
                .andExpect(jsonPath("$.message").value("User with id 4444 has unfollowed user with id 5555"));
    }

    @DisplayName("Verifica que un usuario no es seguidor de otro usuario")
    @Test
    public void testUnFollowUserNoFollowed() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/unfollow/{userIdToUnfollow}", 4444, 1111)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Not following"))
                .andExpect(jsonPath("$.message").value("User with id 4444 is not following user with id 1111"));
    }

    @DisplayName("Verifica que un mismo usuario no pueda dejar de seguirse asi mismo, no es permitida esa accion")
    @Test
    public void testUnFollowSameUser() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/unfollow/{userIdToUnfollow}", 1111, 1111)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Same user"))
                .andExpect(jsonPath("$.message").value("Both user id (1111) are the same, cannot perform this action"));
    }

    @DisplayName("Verifica que un usuario no pueda dejar de seguir a un usuario no existente")
    @Test
    public void testUnFollowNoFoundUser() throws Exception {

        this.mockMvc.perform(
                post("/users/{userId}/unfollow/{userIdToUnfollow}", 4444, 55555)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("User Not Found"))
                .andExpect(jsonPath("$.message").value("User with id 55555 not found"));
    }

    @DisplayName("Verifica la lista de seguidos de un usuario seguidor")
    @Test
    public void testGetUserFollowedListOutput() throws Exception {

        List<ResponseUserDTO> responseUserDTOList = new ArrayList<>();

        ResponseUserDTO responseUserDTOOne = new ResponseUserDTO(5555, "Seller1");
        ResponseUserDTO responseUserDTOTwo = new ResponseUserDTO(6666, "Seller2");
        responseUserDTOList.add(responseUserDTOOne);
        responseUserDTOList.add(responseUserDTOTwo);

        ResponseUserFollowedDTO responseUserFollowedDTO = new ResponseUserFollowedDTO(7777, "Follower Duran", responseUserDTOList);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        String responseJson = writer.writeValueAsString(responseUserFollowedDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/users/{userId}/followed/list", "7777"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("7777"))
                .andExpect(jsonPath("$.user_name").value("Follower Duran"))
                .andReturn();

        Assertions.assertEquals(responseJson, mvcResult.getResponse().getContentAsString());

    }
}
