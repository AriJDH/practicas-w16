package com.example.socialmeli2.integration;

import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.Product;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.repository.PostRepository;
import com.example.socialmeli2.util.Util;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IRepository<Post> postRepository;

    @BeforeEach
    public void initialize() {

        Product product1 = Util.getProduct(1, "Teclado");
        Product product2 = Util.getProduct(2, "Mouse");
        Product product3 = Util.getProduct(2, "Notebook");
        Product product4 = Util.getProduct(2, "Parlantes");
        Product product5 = Util.getProduct(2, "Silla");
        Post post1 = Util.getPost(1, 1, product1, LocalDate.now());
        Post post2 = Util.getPost(2, 1, product2, LocalDate.now().minusDays(7));
        Post post3 = Util.getPost(3, 1, product3, LocalDate.now().minusDays(20));
        Post post4 = Util.getPost(4, 2, product4, LocalDate.now().minusDays(25));
        Post post5 = Util.getPost(5, 2, product5, LocalDate.now());

        postRepository.add(post1);
        postRepository.add(post2);
        postRepository.add(post3);
        postRepository.add(post4);
        postRepository.add(post5);

    }

    @Test
    public void addPostTest() throws Exception {

        String json = "{\n" +
                "    \"user_id\": \"1\",\n" +
                "    \"date\": \"01-08-2022\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red and Black\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 1500.50\n" +
                "}";

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andReturn();
    }

    @Test
    public void addPostExceptionTest() throws Exception {

        String json = "{\n" +
                "    \"user_id\": \"1\",\n" +
                "    \"date\": \"01-08-2022\",\n" +
                "    \"product\": {\n" +
                "        \"product_id\": 1,\n" +
                "        \"product_name\": \"Silla Gamer\",\n" +
                "        \"type\": \"Gamer\",\n" +
                "        \"brand\": \"Racer\",\n" +
                "        \"color\": \"Red & Black\",\n" +
                "        \"notes\": \"Special Edition\"\n" +
                "    },\n" +
                "    \"category\": 100,\n" +
                "    \"price\": 1500.50\n" +
                "}";

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(json))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El campo no puede poseer caracteres especiales."))
                .andReturn();
    }

    @Test
    public void getFollowedPostLastTwoWeeksTest() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value("1"))
                .andExpect(jsonPath("$.posts.[0].user_id").value("2"))
                .andExpect(jsonPath("$.posts.[0].product.product_id").value("2"))
                .andReturn();

        System.out.println(mvcResult);
    }


}