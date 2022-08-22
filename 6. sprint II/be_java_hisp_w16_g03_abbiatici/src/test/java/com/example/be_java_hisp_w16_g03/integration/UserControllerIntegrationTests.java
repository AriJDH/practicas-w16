package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.ExceptionApiDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowedsDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.FollowersDTO;
import com.example.be_java_hisp_w16_g03.entity.User;
import com.example.be_java_hisp_w16_g03.repository.UserRepository;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import com.example.be_java_hisp_w16_g03.utils.MocksUser;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static com.example.be_java_hisp_w16_g03.utils.MocksUser.createSeller;
import static com.example.be_java_hisp_w16_g03.utils.MocksUser.createUser;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTests {

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
    public void givenValidUserIdGetFollowerCount() throws Exception{

        FollowerCountDTO expectedResponseDTO = new FollowerCountDTO(2, "Seller1", 1);

        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(get("/users/{userId}/followers/count", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

    @Test
    public void followUserAlreadyFollowException() throws Exception{

        ExceptionApiDTO expectedResponseDTO = new ExceptionApiDTO("Error", "El usuario con el id: 1 ya es seguidor de : 2");

        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

    @Test
    public void followUserNotSellerException() throws Exception{

        ExceptionApiDTO expectedResponseDTO = new ExceptionApiDTO("Error", "El Usuario: 1 no es vendedor");

        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

    @Test
    public void unFollowUserNotFollowersException() throws Exception{

        ExceptionApiDTO expectedResponseDTO = new ExceptionApiDTO("Error", "El id: 2 no sigue al usuario 1");

        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

    @Test
    public void givenValidUserIdGetFollowedUsers() throws Exception {

        FollowedsDTO expectedResponseDTO = new FollowedsDTO(1, "User1",
                Mapper.userToUserDtoList(List.of(seller)));

        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

    @Test
    public void givenValidUserIdGetMeFollowers() throws Exception {

        FollowersDTO expectedResponseDTO = new FollowersDTO(2, "Seller1",
                Mapper.userToUserDtoList(List.of(user)));

        String expectedJson = writer.writeValueAsString(expectedResponseDTO);

        MvcResult response = this.mockMvc.perform(get("/users/{userId}/followers/list", 2))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();

        assertEquals(expectedJson, response.getResponse().getContentAsString());
    }

}
