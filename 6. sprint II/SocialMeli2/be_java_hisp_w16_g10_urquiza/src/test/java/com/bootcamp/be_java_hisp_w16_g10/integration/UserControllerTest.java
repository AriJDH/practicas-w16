package com.bootcamp.be_java_hisp_w16_g10.integration;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.service.IPostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IPostService postService;

    private ProductReqDTO product;
    private PostReqDTO postUser2;

    @Test
    @DisplayName("Can list all users...")
    public void shouldListAllUsers() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals(MediaType.APPLICATION_JSON_VALUE,
                        mvcResult.getResponse().getContentType());
    }

    @Test
    @DisplayName("Can't follow an user that's not a seller...")
    public void shouldNotFollowAnInvalidUser() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",3,5)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());

    }

    @Test
    @DisplayName("Can follow an user that's a seller...")
    public void shouldFollowAValidUser() throws Exception {
        product = new ProductReqDTO(101,"Silla Ergonómica","Oficina","Erasmo","Black","Con Garantía.");
        postUser2 = new PostReqDTO(2,301,LocalDate.now(),product,777,29999.99);
        postService.save(postUser2);

        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());;
    }

    @Test
    @DisplayName("Can't unfollow someone who isn't followed...")
    public void shouldNotUnfollowValidUser() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",2,1)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());;

    }
}
