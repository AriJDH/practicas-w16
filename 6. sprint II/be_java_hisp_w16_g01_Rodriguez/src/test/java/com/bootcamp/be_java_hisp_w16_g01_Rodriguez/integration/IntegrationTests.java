package com.bootcamp.be_java_hisp_w16_g01_Rodriguez.integration;

import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g01_Rodriguez.utils.FactoryPost;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    @DisplayName("Creacion de una nueva publicacion")
    void createPostIntegrationTest() throws Exception {
        String request = writer.writeValueAsString(FactoryPost.generatePostDto());

        this.mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Publicacion creada correctamente")));
    }

    //Throws MethodArgumentNotValidException
    @Test
    @DisplayName("Create publicacion con UserId no valido")
    void createPostUserNotValidIntegrationTest() throws Exception {
        PostDto post = FactoryPost.generatePostDto();
        post.setUserId(0);

        String request = writer.writeValueAsString(post);
        this.mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("El id debe ser mayor a cero.")));
    }

    //Throws MethodArgumentNotValidException
    @Test
    @DisplayName("Create publicacion con ProductName no valido")
    void createPostProductNotValidIntegrationTest() throws Exception {
        PostDto post = FactoryPost.generatePostDto();
        post.getProduct().setProductName("Este es un producto con un nombre muuuuuuuuuuy laaaaargo");

        String request = writer.writeValueAsString(post);
        this.mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("La longitud no puede superar los 40 caracteres.")));
    }

    //Throws MethodArgumentNotValidException
    @Test
    @DisplayName("Create publicacion con UserId no valido y ProductDto no valido")
    void createPostUserNotValidProductNotValidIntegrationTest() throws Exception {
        PostDto post = FactoryPost.generatePostDto();
        post.setUserId(0);
        post.getProduct().setProductName("Este es un producto con un nombre muuuuuuuuuuy laaaaargo");

        String request = writer.writeValueAsString(post);
        this.mockMvc.perform(
                        post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(request))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("El id debe ser mayor a cero.")))
                .andExpect(content().string(containsString("La longitud no puede superar los 40 caracteres.")));;
    }

    //Throws ConstraintViolationException
    @Test
    @DisplayName("AddFollower con UserId no valido")
    void addFollowerUserNotValidIntegrationTest() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "-1", "2"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //Throws MethodArgumentTypeMismatchException
    @Test
    @DisplayName("AddFollower con UserId null")
    void addFollowerUserNullIntegrationTest() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", "null", "2"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    //Throws MissingServletRequestParameterException
    @Test
    @DisplayName("GetFollowed sin orden")
    void getFollowedNoOrderIntegrationTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", "1"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
