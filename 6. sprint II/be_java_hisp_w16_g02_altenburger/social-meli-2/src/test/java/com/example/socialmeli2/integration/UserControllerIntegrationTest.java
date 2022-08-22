package com.example.socialmeli2.integration;

import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.service.IUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
    public void initialize() {

        userRepository.dropAll();

        User user1 = new User(0, "gonza", new ArrayList<User>(), new ArrayList<User>());
        User user2 = new User(0, "sabri", new ArrayList<User>(), new ArrayList<User>());
        User user3 = new User(0, "pame", new ArrayList<User>(), new ArrayList<User>());
        User user4 = new User(0, "mateo", new ArrayList<User>(), new ArrayList<User>());
        User user5 = new User(0, "erika", new ArrayList<User>(), new ArrayList<User>());
        User user6 = new User(0, "claudio", new ArrayList<User>(), new ArrayList<User>());

        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);
        userRepository.add(user4);
        userRepository.add(user5);
        userRepository.add(user6);

    }

    @Test
    public void testAddFollower() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "1", "2"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddFollowerBadRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "1", "1"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario no puede seguirse a si mismo."))
                .andReturn();
    }

    @Test
    public void testAddFollowerAlreadyFollowing() throws Exception {
        userService.addFollower(2,3);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "2", "3"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario 2 ya sigue al usuario 3."))
                .andReturn();
    }

    @Test
    public void testGetFollowersCountByUserId() throws Exception {
        userService.addFollower(2,1);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "1"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(1))
                .andReturn();
    }

    @Test
    public void testRemoveFollower() throws Exception {

        userService.addFollower(2,1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "2", "1"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk());

    }

    @Test
    public void testRemoveFollowerUserNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "8", "1"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El usuario con codigo 8 no existe."))
                .andReturn();
    }

    @Test
    public void testRemoveFollowerBadRequest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "3", "1"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("No hay un seguidor con el id 1 en la lista de seguidores del usuario 3."))
                .andReturn();
    }

    @Test
    public void testGetFollowersListByUserId() throws Exception {
        userService.addFollower(2,1);
        String jsonFollowers = "{\n" +
                "    \"user_id\": 1,\n" +
                "    \"user_name\": \"gonza\",\n" +
                "    \"followers\": [\n" +
                "        {\n" +
                "            \"user_id\": 2,\n" +
                "            \"user_name\": \"sabri\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", "1"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonFollowers));
    }

    @Test
    public void testGetFollowedListByUserId() throws Exception {
        userService.addFollower(2,1);
        String jsonFollowers = "{\n" +
                "    \"user_id\": 2,\n" +
                "    \"user_name\": \"sabri\",\n" +
                "    \"followed\": [\n" +
                "        {\n" +
                "            \"user_id\": 1,\n" +
                "            \"user_name\": \"gonza\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "2"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonFollowers));
    }
}
