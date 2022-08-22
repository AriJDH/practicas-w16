package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.*;
import com.example.be_java_hisp_w16_g03.entity.Post;
import com.example.be_java_hisp_w16_g03.entity.Product;
import com.example.be_java_hisp_w16_g03.utils.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void addPost() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(5);
        postDTO.setDate(LocalDate.of(2022, 8, 14));
        postDTO.setCategory(4);
        postDTO.setPrice(2140d);
        postDTO.setProduct(new ProductDTO(1, "Cabeza", "Extremo"
                , "Maximo", "Rojo", "vacio"));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String payloadjson = writer.writeValueAsString(postDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadjson))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void getLatestPostsOrderedASCByUserIdTest() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(5);
        postDTO.setDate(LocalDate.of(2022, 8, 14));
        postDTO.setCategory(4);
        postDTO.setPrice(2140d);
        postDTO.setProduct(new ProductDTO(1, "Cabeza", "Extremo"
                , "Maximo", "Rojo", "vacio"));
        List<PostWithIdDTO> listPosts = Arrays.asList(Mapper.postToPostWithIdDto(Mapper.postDtoToEntity(postDTO)));
        listPosts.get(0).setPostId(0);
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setUserId(1);
        postsDTO.setPosts(listPosts);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(postsDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + 1
                        + "/list" + "?order=date_asc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

    @Test
    public void getLatestPostsOrderedDESCByUserIdTest() throws Exception {
        Post post = new Post();
        post.setUserId(5);
        post.setDate(LocalDate.of(2022, 8, 14));
        post.setCategory(4);
        post.setPrice(2140d);
        post.setProduct(new Product(1, "Extremo", "Maximo"
                , "Rojo", "vacio", "Cabeza"));
        List<PostWithIdDTO> listPosts = Arrays.asList(Mapper.postToPostWithIdDto(post));
        listPosts.get(0).setPostId(0);
        PostsDTO postsDTO = new PostsDTO();
        postsDTO.setUserId(1);
        postsDTO.setPosts(listPosts);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String responseJson = writer.writeValueAsString(postsDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/" + 1 +
                        "/list" + "?order=date_desc"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseJson));
    }

    @Test
    public void getErrorForValidation() throws Exception {
        PostDTO postDTO = new PostDTO();
        postDTO.setUserId(5);
        postDTO.setDate(LocalDate.of(2022, 8, 14));
        postDTO.setCategory(4);
        postDTO.setPrice(2140d);
        postDTO.setProduct(new ProductDTO(1, "Cabeza", "Extremo"
                , "Maximo", "Rojo y azul", "vacio"));

        HashMap<String, List<String>> errors = new HashMap<>();
        List<String> listaRes = new ArrayList<>();
        listaRes.add("El campo no puede poseer caracteres especiales");
        errors.put("product.color", listaRes);
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO();
        exceptionApiDTO.setMessage("There are some fields that don't respect validations");
        exceptionApiDTO.setTitle("Payload's Field Not Valid Exception");
        exceptionApiDTO.setErrors(errors);


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();


        String payloadjson = writer.writeValueAsString(postDTO);
        String responsejson = writer.writeValueAsString(exceptionApiDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadjson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().json(responsejson));


    }


}
