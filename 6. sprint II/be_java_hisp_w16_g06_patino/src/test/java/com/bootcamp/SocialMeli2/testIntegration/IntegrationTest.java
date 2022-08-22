package com.bootcamp.SocialMeli2.testIntegration;

import com.bootcamp.SocialMeli2.dto.FollowIdDto;
import com.bootcamp.SocialMeli2.dto.FollowersCountDTO;
import com.bootcamp.SocialMeli2.dto.ProductDTO;
import com.bootcamp.SocialMeli2.dto.RequestPostDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

    @Autowired
    private MockMvc mockMv;

    ObjectWriter writer;
    FollowIdDto followDTO;

    @BeforeEach
    public void start() {

        followDTO = new FollowIdDto(1, 10);
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }

    @Test
    @DisplayName("follow user - Test Integration")
    public void followUser() throws Exception {
        MvcResult mvcResult = mockMv.perform(post("/users/{userId}/follow/{userIdToFollow}",
                        followDTO.getUserId(), followDTO.getUserIdToFollow()))
                //.andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        HttpStatus responseStatusCode = HttpStatus.valueOf(mvcResult.getResponse().getStatus());
        assertEquals(HttpStatus.OK, responseStatusCode);
    }

    @Test
    @DisplayName("follow user Fail - Test Integration")
    public void followUserFail() throws Exception {
        FollowIdDto followedDTO = new FollowIdDto(2, 2);

        MvcResult mvcResult = mockMv.perform(post("/users/{userId}/follow/{userIdToFollow}",
                        followDTO.getUserId(), followDTO.getUserId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        HttpStatus responseStatusCode = HttpStatus.valueOf(mvcResult.getResponse().getStatus());
        assertEquals(HttpStatus.NOT_FOUND, responseStatusCode);
    }

    @Test
    @DisplayName("followers list - Test Integration")
    public void followersList() throws Exception {
        MvcResult mvcResult = mockMv.perform(get("/users/{userId}/followers/list", followDTO.getUserId()))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        HttpStatus responseStatusCode = HttpStatus.valueOf(mvcResult.getResponse().getStatus());
        assertEquals(HttpStatus.OK, responseStatusCode);
    }

    @Test
    @DisplayName("followed list - Test Integration")
    public void followedList() throws Exception {
        MvcResult mvcResult = mockMv.perform(get("/users/{userId}/followed/list", followDTO.getUserId()))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        HttpStatus responseStatusCode = HttpStatus.valueOf(mvcResult.getResponse().getStatus());
        assertEquals(HttpStatus.OK, responseStatusCode);
    }
    @Test
    @DisplayName("Product list - Test Integration")
    public void productList() throws Exception {
        MvcResult mvcResult = mockMv.perform(get("/products/followed/{userId}/list", followDTO.getUserId()))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        HttpStatus responseStatusCode = HttpStatus.valueOf(mvcResult.getResponse().getStatus());
        assertEquals(HttpStatus.OK, responseStatusCode);
    }

    @Test
    @DisplayName("countFollowers - Test Integracion")
    public void countFollowers() throws Exception {

        FollowersCountDTO followersCountDTO = new FollowersCountDTO(1, "Andrés", 2);

        String followersCounDTOJson = writer.writeValueAsString(followersCountDTO);

        MvcResult mvcResult = mockMv.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(followersCounDTOJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    @DisplayName("createPost - Test Integracion")
    public void createPost() throws Exception {

        int responseExpected = 200;
        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
        RequestPostDTO postDto = new RequestPostDTO(1, "11-08-2022", product, 100, 1500.50);

        String postDTOJson = writer.writeValueAsString(postDto);

        MvcResult mvcResult = mockMv.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseExpected, mvcResult.getResponse().getStatus());
    }


    @Test
    @DisplayName("createPostExceptionValid - Test Integracion")
    public void createPostExceptionValid() throws Exception {

        ProductDTO product = new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        RequestPostDTO postDto = new RequestPostDTO(1, "11-08-2022", product, 100, 1500.50);

        String postDTOJson = writer.writeValueAsString(postDto);

        mockMv.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDTOJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.statusCode").value(400));

    }
}
