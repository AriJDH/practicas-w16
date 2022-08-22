package com.example.socialmeli2.service;

import com.example.socialmeli2.dto.UserDto;
import com.example.socialmeli2.dto.UserFollowedListDto;
import com.example.socialmeli2.dto.UserFollowersCountDto;
import com.example.socialmeli2.dto.UserFollowersListDto;
import com.example.socialmeli2.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    UserService userService;

    @Test
    public void followUserTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdtoFollow}", "1", "2"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void countFollowersTest() throws Exception{
        User user1 = new User(10, "Terry", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(11, "Andy", new ArrayList<>(), new ArrayList<>());
        User user3 = new User(12, "Joe", new ArrayList<>(), new ArrayList<>());

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        userService.addFollower(user1.getUserId(), 1);
        userService.addFollower(user2.getUserId(), 1);
        userService.addFollower(user3.getUserId(), 1);

        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUserId(1);
        userFollowersCountDto.setUserName("gonza");
        userFollowersCountDto.setFollowersCount(5);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String responseUserFollowers = writer.writeValueAsString(userFollowersCountDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseUserFollowers))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    public void userToUnfollowTest() throws Exception{
        userService.addFollower(2, 1);
        userService.addFollower(3, 1);
        userService.addFollower(4, 1);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", "2", "1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    public void userFollowersListTest() throws Exception{
        userService.addFollower(3, 2);
        userService.addFollower(4, 2);
        userService.addFollower(5, 2);
        userService.addFollower(6, 2);

        List<UserDto> expectedFollowers = Arrays.asList(
                new UserDto(3, "pame"),
                new UserDto(4, "mateo"),
                new UserDto(5, "erika"),
                new UserDto(6, "claudio")
        );

        Optional<String> order = Optional.of("name_asc");

        UserFollowersListDto userFollowersListDto = new UserFollowersListDto();
        userFollowersListDto.setUserId(2);
        userFollowersListDto.setUserName("sabri");
        userFollowersListDto.setFollowers(expectedFollowers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String responseUserFollowersList = writer.writeValueAsString(userFollowersListDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", "2", order))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseUserFollowersList))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    public void getFollowedByIdTest() throws Exception{
        User user1 = new User(7, "Ryu", new ArrayList<>(), new ArrayList<>());
        User user2 = new User(8, "Ken", new ArrayList<>(), new ArrayList<>());
        User user3 = new User(9, "Guile", new ArrayList<>(), new ArrayList<>());

        userService.add(user1);
        userService.add(user2);
        userService.add(user3);

        userService.addFollower(user1.getUserId(), user2.getUserId());
        userService.addFollower(user1.getUserId(), user3.getUserId());

        Optional<String> order = Optional.of("name_asc");

        List<UserDto> expectedFollowed = Arrays.asList(
                new UserDto(9, "Guile"),
                new UserDto(8, "Ken")
        );

        UserFollowedListDto userFollowedListDto = new UserFollowedListDto();
        userFollowedListDto.setUserId(7);
        userFollowedListDto.setUserName("Ryu");
        userFollowedListDto.setFollowed(expectedFollowed);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String responseUserFollowedList = writer.writeValueAsString(userFollowedListDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "7", order))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseUserFollowedList))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }


}
