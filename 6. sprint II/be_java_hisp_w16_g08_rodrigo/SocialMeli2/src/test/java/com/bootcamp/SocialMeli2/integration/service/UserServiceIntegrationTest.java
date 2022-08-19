package com.bootcamp.SocialMeli2.integration.service;

import com.bootcamp.SocialMeli2.dto.request.PostDto;
import com.bootcamp.SocialMeli2.entiry.Post;
import com.bootcamp.SocialMeli2.entiry.User;
import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.repository.PostRepository;
import com.bootcamp.SocialMeli2.repository.UserRepostirory;
import com.bootcamp.SocialMeli2.service.IProductService;
import com.bootcamp.SocialMeli2.service.ProductService;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IProductService productService;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer().withDefaultPrettyPrinter();

    @BeforeEach
    public  void beforeAll()throws  Exception{
        User user1 = userRepository.getUserById(1);
        User user2 = userRepository.getUserById(2);

        if(user2.getPostMade().size()==0){
            Post post = TestUtils.getOnePost(1,user2,LocalDate.now());
        }
        if(user1.getFollowedList().size()==0){
            user1.getFollowedList().add(user2);
            user2.getFollowerList().add(user1);
        }

    }

    @Test
    @DisplayName("Test de seguida de usuario")
    public void followUserTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2,1))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    @DisplayName("Test para verificar la excepcion de no seguirte a vos mismo")
    public void followUserTestExCanNotFollowYourSelfException() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Can not follow yourself"));
    }
    @Test
    @DisplayName("Test para vericar la exception si ya sigue el usuario")
    public void followUserTestExAlreadyFollowAUserException() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Already follow this user"));
    }

    @Test
    @DisplayName("Test obtener un usuario por su id")
    public void getUserByIdTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{idUser}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.user_name").value("User1"));
    }

    @Test
    @DisplayName("Test obtener cantidad de seguidores de un usuario")
    public void getUserFollowersCount() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("2"))
                .andExpect(jsonPath("$.user_name").value("User2"))
                .andExpect(jsonPath("$.followers_count").value("1"));
    }
    @Test
    @DisplayName("Tees para obtener la excepcion de que el usuario no es un vendedor")
    public void getUserFollowersCountExUserNotVendorException() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",3))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User not vendor"));
    }


    @Test
    @DisplayName("Test para dejar de seguir un usuario")
    public void unfollowUserTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test dejar usuario pero no es seguido")
    public void unfollowUserTestExUserNotFolllowException() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,3))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The user with id: 1 not follow the user with the id: 3"));
    }
    @Test
    @DisplayName("Test en el que uno de los usuarios buscados no existe")
    public void unfollowUserTestExUserNotFoundException() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",1,99))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User was not found"));
    }

    @Test
    @DisplayName("Test para ver los vendedores que sigue un usuario")
    public void getVendorsFollowedByUserTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                 .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.userId").value("1"))
                .andExpect(jsonPath("$.userName").value("User1"))
                .andExpect(jsonPath("$.followed[0].user_id").value("2"))
                .andExpect(jsonPath("$.followed[0].user_name").value("User2"));
    }
    @Test
    @DisplayName("Test de lanzado de excepcion cuando el orden que se pasa no es correcto")
    public void getVendorsFollowedByUserTestExOrderNotPossibleException() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1).param("order","juan"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("That sorting order is not valid"));
    }

    @Test
    @DisplayName("Test para ver los seguidores de un vendedor")
    public void requestAllFollowersTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list",2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("2"))
                .andExpect(jsonPath("$.user_name").value("User2"))
                .andExpect(jsonPath("$.followers[0].user_id").value("1"))
                .andExpect(jsonPath("$.followers[0].user_name").value("User1"));
    }
    @Test
    @DisplayName("Test para ver los post de los que sigue un usuario")
    public void requestPostFromFollowed() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.posts[0].post_id").value("1"))
                .andExpect(jsonPath("$.posts[0].user_id").value("2"));
    }
}

