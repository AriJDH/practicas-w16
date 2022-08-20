package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.UserDto;
import com.example.socialmeli2.dto.UserFollowedListDto;
import com.example.socialmeli2.dto.UserFollowersCountDto;
import com.example.socialmeli2.dto.UserFollowersListDto;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.repository.UserRepository;
import com.example.socialmeli2.service.IUserService;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    private IRepository<User> userRepository;
    @Autowired
    private IUserService userService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void reset() {
        ((UserRepository) userRepository).clear();

        User marcos = Util.getUser(1, "Marcos Galperin");
        User gonzalo = Util.getUser(2, "Gonzalo Nahuel Di Pierro");
        User pamela = Util.getUser(3, "Pamela Pereyra");

        userRepository.add(marcos);
        userRepository.add(gonzalo);
        userRepository.add(pamela);
    }

    @Test
    @DisplayName("STATUS_OK: agregar seguidor a un usuario")
    public void addFollowerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "2", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("BAD_REQUEST: se quiere agregar un usuario inexistente, como seguidor, a un usuario que si existe")
    public void addInvalidFollowerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "10", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("STATUS_OK: obtener la cantidad de seguidores de un usuario")
    public void getFollowersCountByUserIdTest() throws Exception {
        userService.addFollower(2, 1);
        userService.addFollower(3, 1);

        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUserId(1);
        userFollowersCountDto.setUserName("Marcos Galperin");
        userFollowersCountDto.setFollowersCount(2);

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
    @DisplayName("STATUS_OK: eliminar seguidor a un usuario")
    public void removeFollowerTest() throws Exception {
        userService.addFollower(2, 1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "2", "1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("BAD_REQUEST: se quiere eliminar un inexistente seguidor a un usuario")
    public void removeInvalidFollowerTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "2", "1"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("STATUS_OK: obtener la lista de seguidores de un usuario")
    public void getFollowersListByUserIdTest() throws Exception {
        userService.addFollower(2, 1);
        userService.addFollower(3, 1);

        UserFollowersListDto userFollowersListDto = new UserFollowersListDto();
        userFollowersListDto.setUserId(1);
        userFollowersListDto.setUserName("Marcos Galperin");
        userFollowersListDto.setFollowers(Arrays.asList(
                new UserDto(2, "Gonzalo Nahuel Di Pierro"),
                new UserDto(3, "Pamela Pereyra")
        ));

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
    @DisplayName("STATUS_OK: obtener la lista de seguidos de un usuario")
    public void getFollowedListByUserIdTest() throws Exception {
        userService.addFollower(2, 1);
        userService.addFollower(2, 3);

        UserFollowedListDto userFollowedListDto = new UserFollowedListDto();
        userFollowedListDto.setUserId(2);
        userFollowedListDto.setUserName("Gonzalo Nahuel Di Pierro");
        userFollowedListDto.setFollowed(Arrays.asList(
                new UserDto(1, "Marcos Galperin"),
                new UserDto(3, "Pamela Pereyra")
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseUserFollowedListDtoJson = writer.writeValueAsString(userFollowedListDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseUserFollowedListDtoJson, mvcResult.getResponse().getContentAsString());
    }
}
