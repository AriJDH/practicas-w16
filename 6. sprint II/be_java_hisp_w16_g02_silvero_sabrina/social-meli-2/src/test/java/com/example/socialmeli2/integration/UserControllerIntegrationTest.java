package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.UserDto;
import com.example.socialmeli2.dto.UserFollowedListDto;
import com.example.socialmeli2.dto.UserFollowersCountDto;
import com.example.socialmeli2.dto.UserFollowersListDto;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.repository.UserRepository;
import com.example.socialmeli2.service.UserService;
import com.example.socialmeli2.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IRepository<User> userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void reset() {
        ((UserRepository) userRepository).clear();
        User gonza = Util.getUser(1, "gonza");
        User erika = Util.getUser(2, "erika");
        User pame = Util.getUser(3, "pame");
        User mateo = Util.getUser(4, "mateo");
        User sabrina = Util.getUser(5, "sabrina");
        User claudio = Util.getUser(6, "claudio");
        userRepository.add(gonza);
        userRepository.add(erika);
        userRepository.add(pame);
        userRepository.add(mateo);
        userRepository.add(sabrina);
        userRepository.add(claudio);
    }
    @Test
    @DisplayName("Agregar seguidor existente a un usuario")
    public void testAddFollower() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "5", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("No se puede seguir a un usuario no existente")
    public void testAddInvalidFollower() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "8", "1"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Dejar de seguir a un usuario")
    public void testRemoveFollower() throws Exception {
        userService.addFollower(5, 1);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "5", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("No se puede dejar de seguir a un usuario no existente")
    public void testRemoveInvalidFollower() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "5", "1"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Cantidad de seguidores de un usuario existente")
    void testGetFollowersCountByUserId() throws Exception {
        userService.addFollower(2, 1);
        userService.addFollower(3, 1);
        userService.addFollower(4, 1);
        userService.addFollower(5, 1);

        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUserId(1);
        userFollowersCountDto.setUserName("gonza");
        userFollowersCountDto.setFollowersCount(4);

        // Conversion de Dto a Json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseUserFollowerCountDtoJson = writer.writeValueAsString(userFollowersCountDto);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseUserFollowerCountDtoJson));
    }

    @Test
    @DisplayName("Lista de seguidores de un usuario existente")
    void testGetFollowersListByUserId() throws Exception {
        userService.addFollower(2, 1);
        userService.addFollower(3, 1);
        userService.addFollower(4, 1);

        UserFollowersListDto userFollowersListDto = new UserFollowersListDto();
        userFollowersListDto .setUserId(1);
        userFollowersListDto.setUserName("gonza");
        userFollowersListDto.setFollowers(Arrays.asList(
                new UserDto(2, "erika"),
                new UserDto(3, "pame"),
                new UserDto(4, "mateo")));

        // Conversion de Dto a Json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseUserFollowerListDtoJson = writer.writeValueAsString(userFollowersListDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseUserFollowerListDtoJson, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Lista de seguidos de un usuario existente")
    void testGetFollowedListByUserId() throws Exception {
        userService.addFollower(1, 2);
        userService.addFollower(1, 3);
        userService.addFollower(1, 4);

        UserFollowedListDto userFollowedListDto = new UserFollowedListDto();
        userFollowedListDto .setUserId(1);
        userFollowedListDto.setUserName("gonza");
        userFollowedListDto.setFollowed(Arrays.asList(
                new UserDto(2, "erika"),
                new UserDto(3, "pame"),
                new UserDto(4, "mateo")));

        // Conversion de Dto a Json
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseUserFollowedListDtoJson = writer.writeValueAsString(userFollowedListDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseUserFollowedListDtoJson, mvcResult.getResponse().getContentAsString());
    }
}