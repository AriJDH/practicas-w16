package com.bootcamp.SocialMeli2_gonzalez.integration.service;

import com.bootcamp.SocialMeli2_gonzalez.entiry.Post;
import com.bootcamp.SocialMeli2_gonzalez.entiry.User;
import com.bootcamp.SocialMeli2_gonzalez.repository.IPostRepository;
import com.bootcamp.SocialMeli2_gonzalez.repository.IUserRepository;
import com.bootcamp.SocialMeli2_gonzalez.service.IUserService;
import com.bootcamp.SocialMeli2_gonzalez.utils.TestUtils;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserRestControllerTest {

    @Autowired
    IUserService iUserService;

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IUserRepository iUserRepository;

    @Autowired
    private MockMvc mockMvc;


    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer().withDefaultPrettyPrinter();

    @BeforeEach
    public void setupInit () throws Exception{

        User usr1 = iUserRepository.getUserById(1);
        User usr2 = iUserRepository.getUserById(2);

        if(usr1.getFollowedList().size()==0){
            usr1.getFollowedList().add(usr2);
            usr2.getFollowerList().add(usr1);
        }

        //creo un post para convertir en vendedor al usr2
        if(usr2.getPostMade().size() == 0){
            Post post = TestUtils.getOnePost(1, usr2, LocalDate.now());

        }

    }

    @Test
    @DisplayName("Test que verifica seguir a un usuario")
    public void followUserTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test que verifica que no se puede seguir a un usuario que ya sigue")
    public void reFollowUserTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Already follow this user"));
    }


    @Test
    @DisplayName("Test que verifica generar la Excepcion en caso de querer seguirse a si mismo")
    public void followUserExceptionTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Can not follow yourself"));
    }

    @Test
    @DisplayName("Cantidad de seguidores de un usuario")
    public void getUserFollowersCountTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.followers_count").value(1));

    }

    @Test
    @DisplayName("Verificar exception si el usuario no es vendedor")
    public void getUserFollowersCountTestException() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 3))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User not vendor"));

    }

    @Test
    @DisplayName("Verificar la obtencion del usuario segun su id")
    public void getUserByIdTest() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_name").value("User2"));
    }

    @Test
    @DisplayName("Verificar la obtencion de la exception si el id de usuario no existe")
    public void getUserByIdTestException() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}", 8))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User was not found"));

    }

    @Test
    @DisplayName("Verificar la accion de dejar de seguir a un usuario")
    public void unfollowUserTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 1,2))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Verificar la accion de dejar de seguir a un usuario que no es seguido")
    public void unfollowUserExceptionTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 2, 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("The user with id: 2 not follow the user with the id: 1"));
    }


    @Test
    @DisplayName("Verificar la cantidad de vendedores que sigue un usuario")
    public void getVendorsFollowedByUserTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_name").value("User2"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followed[0].user_id").value("2"));
    }

    @Test
    @DisplayName("Verifica si se pasa un orden de ordenamiento incorrecto")
    public void getVendorsFollowedByUserExceptionTest() throws  Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1).param("order","juan"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("That sorting order is not valid"));
    }

    @Test
    @DisplayName("Verificar todos los seguidores de un vendendor")
    public void requestAllFollowersTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("User1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value("1"));
    }

    @Test
    @DisplayName("Verificar la accion de dejar de seguir a un usuario que no es seguido")
    public void requestAllFollowersExceptionTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User not vendor"));
    }

    @Test
    @DisplayName("Verificar ")
    public void requestPostFromFollowedTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.posts[0].post_id").value("1"))
                .andExpect(jsonPath("$.posts[0].user_id").value("2"));
    }


    @Test
    @DisplayName("Verificar la accion de dejar de seguir a un usuario que no es seguido")
    public void requestPostFromFollowedExceptionTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1).param("order", "lslsls"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("That sorting order is not valid"));
    }


}
