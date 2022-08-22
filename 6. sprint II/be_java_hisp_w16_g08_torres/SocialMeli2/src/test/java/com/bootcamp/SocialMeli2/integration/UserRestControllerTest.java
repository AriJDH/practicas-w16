package com.bootcamp.SocialMeli2.integration;

import com.bootcamp.SocialMeli2.entiry.User;
import com.bootcamp.SocialMeli2.exception.AlreadyFollowAUserException;
import com.bootcamp.SocialMeli2.exception.CanNotFollowYourSelfException;
import com.bootcamp.SocialMeli2.exception.UserNotFoundException;
import com.bootcamp.SocialMeli2.exception.UserNotVendorException;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.service.IProductService;
import com.bootcamp.SocialMeli2.service.IUserService;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IUserService userService;
    @Autowired
    private IProductService productService;

    @BeforeEach
    private void setUp(){
        User user1 = userRepository.getUserById(1);
        User user2 = userRepository.getUserById(2);
        User user3 = userRepository.getUserById(3);

        if(user1.getFollowedList().size() == 0) {
            productService.publishPost(TestUtils.getOnePostDto(2));
            productService.publishPost(TestUtils.getOnePostDto(5));
            productService.publishPost(TestUtils.getOnePostDto(4));
            userService.addFollower(user1.getUserId(),2);
            userService.addFollower(user2.getUserId(),5);
            userService.addFollower(user2.getUserId(),4);
            userService.addFollower(user3.getUserId(),2);
        }

    }

    @Test
    @DisplayName("Obtener usuario por id")
    public void getUserByIdTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{idUser}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.user_name").value("User1"));
    }

    @Test
    @DisplayName("Seguir a un usuario que sea vendedor")
    public void followUser() throws Exception{
        User user = TestUtils.getOneUser(6, "Juan");
        userRepository.addUser(user);
        productService.publishPost(TestUtils.getOnePostDto(6));
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}","1","6"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Seguir a un usuario que no exista")
    public void followUserNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "1", "1000"))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotFoundException));

    }

    @Test
    @DisplayName("Seguirse a si mismo")
    public void followYourself() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "1", "1"))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CanNotFollowYourSelfException));

    }

    @Test
    @DisplayName("Seguir a un usuario que ya sigue")
    public void alreadyFollowUser() throws Exception{
        User user = TestUtils.getOneUser(6, "Juan");
        userRepository.addUser(user);
        productService.publishPost(TestUtils.getOnePostDto(6));
        userService.addFollower(1, 6);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "1", "6"))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof AlreadyFollowAUserException));

    }

    @Test
    @DisplayName("Obtener cantidad de seguidores que tiene un usuario vendedor")
    public void getUserFollowerCount() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("2"))
                .andExpect(jsonPath("$.user_name").value("User2"))
                .andExpect(jsonPath("$.followers_count").value(2));
    }

    @Test
    @DisplayName("Obtener cantidad de seguidores que tiene un usuario no vendedor")
    public void getNotvendorUserFollowerCount() throws Exception {
        User horacio = TestUtils.getOneUser(7, "Horacio");
        userRepository.addUser(horacio);
        userService.addFollower(1,7);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",7))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotVendorException));

    }

    @Test
    @DisplayName("Dejar de seguir a un usuario")
    public void unfollowUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 5))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Obtener publicaciones de usarios vendedores que sigue un usuario")
    public void getPostFromFollowed() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts[0].user_id").value(2))
                .andExpect(jsonPath("$.posts[0].post_id").value(1));
    }










}
