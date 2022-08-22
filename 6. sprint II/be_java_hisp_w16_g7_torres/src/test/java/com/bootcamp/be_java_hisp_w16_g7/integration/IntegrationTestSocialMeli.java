package com.bootcamp.be_java_hisp_w16_g7.integration;

import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.Post;
import com.bootcamp.be_java_hisp_w16_g7.entity.Product;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g7.service.UserService;
import com.bootcamp.be_java_hisp_w16_g7.util.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestSocialMeli {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectWriter writer;



    @BeforeAll
    public static void setUp() throws Exception{
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void beforeEach() throws Exception{
        PostDTO payloadDTO = new PostDTO(1111, LocalDate.of(2022, 8, 10), new ProductDTO(1,"Moto","Vehiculo","WWW","Rojo","Nuevo"), 99, 1000.0);
        String payloadJSON = writer.writeValueAsString(payloadDTO);
        mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJSON))
                .andExpect(status().isOk());
    }

    @Test
    public void followUserTest() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2222, 1111))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Follow user"))
                .andExpect(jsonPath("$.message").value("User with id 2222 has followed user with id 1111"));
    }

    @Test
    public void followSameUserTest() throws Exception{
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1111, 1111))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Same user"))
                .andExpect(jsonPath("$.message").value("Both user id (1111) are the same, cannot perform this action"));
    }

    @Test
    public void getSellerFollowersNotFoundTest() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", 5555))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("User Not Found"))
                .andExpect(jsonPath("$.message").value("User with id 5555 not found"));
    }

    @Test
    public void getSellerFollowersTest() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list", 1111))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1111))
                .andExpect(jsonPath("$.user_name").value("John Doe"));
    }

    @Test
    public void getFollowersCountTest() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 1111))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(1111))
                .andExpect(jsonPath("$.user_name").value("John Doe"));
    }

}
