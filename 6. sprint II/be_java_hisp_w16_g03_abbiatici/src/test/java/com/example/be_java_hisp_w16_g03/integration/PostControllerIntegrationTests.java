package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.PostsDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.UserRepository;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import com.example.be_java_hisp_w16_g03.utils.initUsers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.List;

import static com.example.be_java_hisp_w16_g03.utils.MocksUser.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;
    User user;
    User seller;

    @Autowired
    UserRepository repository;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @BeforeEach
    public void beforEach() {

        user = createUser();
        seller = createSeller();
        user.setFolloweds(List.of(seller));
        seller.setFollowers(List.of(user));

        this.repository.setUsers(initUsers.initUserList());
    }

    @Test
    public void testGivenValidUserIdGetFollowedPostsLastTwoWeeksDefault() throws Exception{

        PostsDTO expectedResponseDTO = PostsDTO.builder().userId(1).posts(Mapper.postToPostWithIdDtoList(seller.getPosts())).build();

        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());

    }

    @Test
    public void testGivenValidPostAddPost() throws Exception{

        PostDTO payloadDTO = new PostDTO(2, LocalDate.now(),
                new ProductDTO(1, "K70", "Mecanico", "Corsair",
                        "Black", "MX Cherry Silver"),
                50, 1000.0);

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

}
