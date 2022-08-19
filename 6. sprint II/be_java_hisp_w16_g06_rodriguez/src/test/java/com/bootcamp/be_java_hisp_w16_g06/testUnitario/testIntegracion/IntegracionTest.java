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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

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
    @DisplayName("Not found user id for list followers")
    public void listFollowersNotFoundTest() throws Exception{

        int userId = 78;

        this.mockMv.perform(get("/users/{userId}/followers/list", userId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.statusCode").value(404));

    }


    @Test
    @DisplayName("List followed")
    public void listFollowedTest() throws Exception{

        List<ListFollowedDTO> listFollowed = new ArrayList<>();

        ListFollowedDTO userOne = new ListFollowedDTO(3, "AndreaSeguida");
        ListFollowedDTO userTwo = new ListFollowedDTO(2, "JulianaSeguida");

        listFollowed.add(userOne);
        listFollowed.add(userTwo);

        FollowedDTO followedDTO = new FollowedDTO();
        followedDTO.setUser_id(1);
        followedDTO.setUser_name("Andrés");
        followedDTO.setFollowed(listFollowed);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String followedDtoString = writer.writeValueAsString(followedDTO);


        MvcResult mvcResult = this.mockMv.perform(get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(followedDtoString, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    public void listPostErrorOrderTest() throws Exception {

        int userId = 1;
        String order = "fsk";

        this.mockMv.perform(get("/products/followed/{userId}/list?order=" + order, userId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.statusCode").value(400));

    }



    @Test
    public void listPostOrderTest() throws Exception {

        int userId = 1;
        int statusExpected = 200;

        MvcResult mvcResult = this.mockMv.perform(get("/products/followed/{userId}/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(statusExpected, mvcResult.getResponse().getStatus());

    }


}
