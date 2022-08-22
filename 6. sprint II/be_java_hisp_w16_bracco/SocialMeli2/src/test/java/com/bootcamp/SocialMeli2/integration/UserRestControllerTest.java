package com.bootcamp.SocialMeli2.integration;

import com.bootcamp.SocialMeli2.entity.User;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.service.IUserService;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IUserRepository iUserRepository;
    private User user1;

    @BeforeEach
    void setUp() {
        user1 = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        iUserRepository.addUser(user1);
    }

    @Test
    void getUserFollowresCountTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("luis"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    void getUserFollowersFromUserNotVendor() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("User not vendor"));
    }

    @Test
    void unfollowUserTest() throws Exception {
        User userToUnfollow = user1.getFollowedList().get(0);
        iUserRepository.addUser(user1);
        iUserRepository.addUser(userToUnfollow);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, userToUnfollow.getUserId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getAllVendorsFollowedByUserTest() throws Exception {
        User userThatFollowAVendor = user1.getFollowedList().get(0);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",userThatFollowAVendor.getUserId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void requestAllFollowersFromVendorTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void requestAllFollowersFromUserNotVendorTest() throws Exception {
        User userNotVendor = TestUtils.getOneUser(4,"Horacio");
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",userNotVendor.getUserId()))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("User not vendor"));
    }



    @Test
    void unfollowUserFailTest() throws Exception {
           this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 3))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The user with id: 1 not follow the user with the id: 3"));
    }




    @Test
    void requestPostFromFollowedTest() throws Exception {
        User userToListVendorPost = user1.getFollowedList().get(0);
        iUserRepository.addUser(userToListVendorPost);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2))
            .andDo(print())
            .andExpect(status().isOk());

    }

    @Test
    void requestPostFromFollowedNoExistsIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 12))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("User was not found"));
    }

    @Test
    void followAUserAlreadyFollowedTest() throws Exception{
        User userThatAlreadyFollowsAUser = user1.getFollowedList().get(0);
        iUserService.addFollower(userThatAlreadyFollowsAUser.getUserId(), user1.getUserId());
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",userThatAlreadyFollowsAUser.getUserId(),user1.getUserId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Already follow this user"));
    }

    @Test
    void followYourSelfTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",user1.getUserId(),user1.getUserId()))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Can not follow yourself"));
    }


    @Test
    void requestPostFromFollowedWithParamDescTest() throws Exception {
        User userToListVendorPost = user1.getFollowedList().get(0);
        iUserRepository.addUser(userToListVendorPost);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2) .param("order","date_desc"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void requestPostFromFollowedWithParamAscTest() throws Exception {
        User userToListVendorPost = user1.getFollowedList().get(0);
        iUserRepository.addUser(userToListVendorPost);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2) .param("order","date_asc"))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void requestPostFromFollowedWithIncorrectParamTest() throws Exception {
        User userToListVendorPost = user1.getFollowedList().get(0);
        iUserRepository.addUser(userToListVendorPost);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2) .param("order","lala"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("That sorting order is not valid"));

    }
}

