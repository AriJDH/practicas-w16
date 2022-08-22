package com.bootcamp.be_java_hisp_w16_g06.testUnitario.testIntegracion;

import com.bootcamp.be_java_hisp_w16_g06.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
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

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegracionTest {

    @Autowired
    private MockMvc mockMv;

    @Test
    @DisplayName("countFollowers - Test Integracion")
    public void countFollowers() throws Exception {

        FollowersCountDTO followersCountDTO = new FollowersCountDTO(1, "Andrés", 2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String followersCounDTOJson = writer.writeValueAsString(followersCountDTO);

        MvcResult mvcResult = this.mockMv.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(followersCounDTOJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("createPost - Test Integracion")
    public void createPost() throws Exception {

        int responseExpected = 200;
        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
        RequestPostDTO postDto = new RequestPostDTO(1, "11-08-2022", product, 100, 1500.50);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String postDTOJson = writer.writeValueAsString(postDto);

        MvcResult mvcResult = this.mockMv.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(responseExpected, mvcResult.getResponse().getStatus());
    }


    @Test
    @DisplayName("createPostExceptionValid - Test Integracion")
    public void createPostExceptionValid() throws Exception {

        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        RequestPostDTO postDto = new RequestPostDTO(1, "11-08-2022", product, 100, 1500.50);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String postDTOJson = writer.writeValueAsString(postDto);


        this.mockMv.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.statusCode").value(400));

    }

    @Test
    @DisplayName("Follwers List")
    public void followersList() throws Exception{

        List<ListFollowersDTO> listFollowers = new ArrayList<>();

        ListFollowersDTO user1 = new ListFollowersDTO(2, "Puga");
        ListFollowersDTO user2 = new ListFollowersDTO(1, "Saul");
        listFollowers.add(user1);
        listFollowers.add(user2);

        FollowersDTO followersDTO = new FollowersDTO();
        followersDTO.setUser_id(1);
        followersDTO.setUser_name("Andrés");
        followersDTO.setFollowers(listFollowers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String followersDTOString = writer.writeValueAsString(followersDTO);


        MvcResult mvcResult = this.mockMv.perform(get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(followersDTOString, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }
}
