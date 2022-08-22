package com.bootcamp.be_java_hisp_w16_g06.testUnitario.testIntegracion;

import com.bootcamp.be_java_hisp_w16_g06.dto.*;
import com.bootcamp.be_java_hisp_w16_g06.entity.Follow;
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
    @DisplayName("followedNotFoundException - Test Integracion")
    public void followedNotFoundException() throws Exception {

        this.mockMv.perform(get("/users/{userId}/followed/list", 4))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.statusCode").value(404));

    }

    @Test
    @DisplayName("followedList - Test Integracion")
    public void followedList() throws Exception {

        ListFollowedDTO followed1 = new ListFollowedDTO(3, "AndreaSeguida");
        ListFollowedDTO followed2 = new ListFollowedDTO(2, "JulianaSeguida");
        List<ListFollowedDTO> list = new ArrayList<>();
        list.add(followed1);
        list.add(followed2);
        FollowedDTO followed = new FollowedDTO(1,"Andrés",list);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String followedDTOJson = writer.writeValueAsString(followed);


        MvcResult mvcResult = this.mockMv.perform(get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(followedDTOJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
