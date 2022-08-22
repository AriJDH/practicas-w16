package com.bootcamp.SocialMeli2.integration.service;

import com.bootcamp.SocialMeli2.entiry.Post;
import com.bootcamp.SocialMeli2.entiry.User;
import com.bootcamp.SocialMeli2.exception.*;
import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.service.IProductService;
import com.bootcamp.SocialMeli2.service.IUserService;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceIntegration {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    IUserService userService;
    @Autowired
    IUserRepository userRepository;
    @Autowired
    IProductService productService;
    @Autowired
    IPostRepository postRepository;



    @BeforeEach
    public void setUp(){
        User usuarioSeguido = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        userRepository.addUser(usuarioSeguido);
    }

    @Test
    @DisplayName("I0001 - Usuario seguido")
    public void FollowUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").value(2));

    }

    @Test
    @DisplayName("I0002 - Excepcion is not vendor")
    public void followUserNotVendor() throws Exception{

        User user1 = TestUtils.getOneUser(15, "Daniel");
        userRepository.addUser(user1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",15))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotVendorException));
    }

    @Test
    @DisplayName("I0003 - Obtener usuario")
    public void findUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{idUser}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.user_name").value("luis"));
    }

    @Test
    @DisplayName("I0004 - Usuario no encontrado")
    public void userNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{idUser}", 40))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof UserNotFoundException));
    }

    @Test
    @DisplayName("I0005 - Seguir a usuario correcto")
    public void followUser() throws Exception {
        User newFollowed = TestUtils.getOneUser(10,"Daniel");
        userRepository.addUser(newFollowed);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 10, 1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(""))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("I0006 - Seguir asi mismo")
    public void followYourSelf() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof CanNotFollowYourSelfException));
    }

    @Test
    @DisplayName("I0007 - Seguir a usuario ya seguido")
    public void followUserAllReadyFollow() throws Exception {

        User user1 = TestUtils.getOneUser(10, "Daniel");
        User user2 = TestUtils.getOneUser(11, "Dani2");

        user1.getFollowerList().add(user2);
        user2.getFollowedList().add(user1);

        userRepository.addUser(user1);
        userRepository.addUser(user2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 11, 10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof AlreadyFollowAUserException));
    }

    @Test
    @DisplayName("I0007 - Dejar de seguir seguidor y seguido existentes")
    public void unfollowUser() throws Exception {

        userRepository.getUserById(1).getFollowerList().forEach(e -> userRepository.addUser(e));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 3, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("I0008 - Dejar de seguir seguidor, usuarios no se siguen")
    public void unfollowUserIsNotFollow() throws Exception {
        User usuario1 = TestUtils.getOneUser(6, "Daniel");
        userRepository.addUser(usuario1);
        //userRepository.getUserById(1).getFollowerList().forEach(e -> userRepository.addUser(e));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 6, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("I0009 - Dejar de seguir seguidor usuario inexistente")
    public void unfollowUserFollowerNotExist() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("I0010 - Lista de seguidores sin parametros")
    public void followList() throws Exception {
        User user1 = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        userRepository.addUser(user1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.followed[0].user_id").value(2));
    }
    @Test
    @DisplayName("I0011 - Lista seguidores con ordenamiento desc")
    public void followListWithOrderDesc() throws Exception {
        User user1 = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        userRepository.addUser(user1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .param("order","name_desc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.followed[0].user_id").value(2));
    }

    @Test
    @DisplayName("I0012 - Lista seguidores con ordenamiento asc")
    public void followListWithOrderAsc() throws Exception {
        User user1 = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        userRepository.addUser(user1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .param("order","name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.followed[0].user_id").value(3));
    }

    @Test
    @DisplayName("I0013 - Lista seguidores con ordenamiento asc")
    public void followListWithOrderException() throws Exception {
        User user1 = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        userRepository.addUser(user1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1)
                        .param("order","Lalala")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof OrderNotPossibleException));
    }

    @Test
    @DisplayName("I0014 - Lista de posteos")
    public void postList() throws Exception {
        User user1 = TestUtils.generateVendorWithTwoFollowersAndTwoFollowed();
        userRepository.addUser(user1);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1))
                .andExpect(jsonPath("$.posts[0].post_id").value(1));
    }
}
