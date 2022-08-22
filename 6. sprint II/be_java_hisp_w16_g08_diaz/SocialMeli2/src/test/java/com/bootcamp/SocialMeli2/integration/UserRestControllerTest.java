package com.bootcamp.SocialMeli2.integration;

import com.bootcamp.SocialMeli2.dto.response.UserFollowersCountDto;
import com.bootcamp.SocialMeli2.entiry.User;
import com.bootcamp.SocialMeli2.exception.*;
import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.repository.UserRepostirory;
import com.bootcamp.SocialMeli2.service.IProductService;
import com.bootcamp.SocialMeli2.service.IUserService;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import com.google.gson.Gson;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IUserRepository userRepo;
    @Autowired
    IUserService userService;
    @Autowired
    IProductService productService;

    @BeforeEach
    public void setUp() {
        User user5 = userRepo.getUserById(5);
        User user4 = userRepo.getUserById(4);
        User user3 = userRepo.getUserById(3);
        User user2 = userRepo.getUserById(2);

        if (user5.getFollowerList().size() == 0) {
            productService.publishPost(TestUtils.getOnePostDto(5));
            productService.publishPost(TestUtils.getOnePostDto(5));
            productService.publishPost(TestUtils.getOnePostDto(4));
            userService.addFollower(user4.getUserId(), 5);
            userService.addFollower(user2.getUserId(), 5);
            userService.addFollower(user2.getUserId(), 4);
            userService.addFollower(user3.getUserId(), 5);
        }
    }


    @Test
    @DisplayName("\"/users/{userId}/follow/{userIdToFollow}\" - Follow another User")
    void followUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("\"/users/{userId}/follow/{userIdToFollow}\" - AlreadyFollow")
    void alreadyFollowedUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 5))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof AlreadyFollowAUserException));
    }

    @Test
    @DisplayName("\"/users/{userId}/follow/{userIdToFollow}\" - FolloweYourself")
    void FollowyourselfTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CanNotFollowYourSelfException));
    }

    @Test
    @DisplayName("\"/users/{userId}/follow/{userIdToFollow}\" - Follow  inexistent User")
    void followUserFollowerNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 999, 2))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("User was not found"))
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotFoundException));


    }


    @Test
    @DisplayName("\"/users/{userId}/followers/count\" - CheckFollowerCount")
    void getUserFollowersCount() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 9))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotFoundException));
    }

    @Test
    @DisplayName("\"/users/{userId}/followers/count\" - UserNotVendor")
    void getUserFollowersCountException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("/users/{userId}/unfollow/{userIdToUnfollow} - OK")
    void unfollowUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 4, 5))
                .andDo(print())
                .andExpect(status().isOk());
    }


    @Test
    @DisplayName("/users/{userId}/unfollow/{userIdToUnfollow} - Dejar de seguir un usuario inexistente")
    void unfollowNotExistUserTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 4, 999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotFoundException));
    }

    @Test
    @DisplayName("/users/{userId}/unfollow/{userIdToUnfollow} - Dejar de seguir a un usuario que no sigo")
    void unfollowUserThatNotFollows() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 1, 3))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotFolllowException));
    }


    @Test
    @DisplayName("/users/{userId}/followed/list - Orden descendiente")
    void getVendorsFollowedByUserDescTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 2)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/users/{userId}/followed/list Orden Ascendiente")
    void getVendorsFollowedByUserAscTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 2)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/users/{userId}/followed/list - Intentando ordenar por lalala")
    void getVendorsFollowedByUserException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 2)
                        .param("order", "lalala"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof OrderNotPossibleException));
    }

    @Test
    @DisplayName("/users/{userId}/followers/list - Ordenado por ascendente")
    void requestAllFollowersAscOrderedTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 5)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/users/{userId}/followers/list - Ordenado por descendente")
    void requestAllFollowersDescOrderedTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 5)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("/users/{userId}/followers/list - Ordenado por ascendente")
    void requestAllFollowersOrderNotPossibleTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 5)
                        .param("order", "lalala"))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof OrderNotPossibleException));
    }

    @Test
    @DisplayName("/products/followed/{userId}/list")
    void requestPostFromFollowed() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2))
                .andDo(print())
                .andExpect(status().isOk());


    }
}
