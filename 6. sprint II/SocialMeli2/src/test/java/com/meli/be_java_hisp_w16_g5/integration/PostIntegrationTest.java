package com.meli.be_java_hisp_w16_g5.integration;

import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.repository.ProductRepository;
import com.meli.be_java_hisp_w16_g5.repository.UserRepository;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    private static String BASE_URL ="/products";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {

        User user1 = UtilTestTools.createCompletedUser("Gae", 1);
        User user2 = UtilTestTools.createUser("Johannes", 2);
        User user3 = UtilTestTools.createUser("Ignacio", 3);

        List<User> users = List.of(user1, user2, user3);

        this.userRepository.save(users);

        Product productSilla = new Product(1,"Silla gamer","Silla","Lagotech","Black","Silla gamer lagotech negra");
        Product productMesa = new Product(2,"Mesa gamer","mesa","Lagotech","Black","Silla gamer lagotech negra");
        Product productMouse = new Product(3,"Mouse gamer","mouse","Lagotech","Black","Silla gamer lagotech negra");

        List<Product> products = List.of(productSilla, productMesa, productMouse);

        this.productRepository.save(products);
    }

    @Test
    public void savePost() throws Exception {
        User u = UtilTestTools.createUser("Philip", 1);
        Post postSilla = UtilTestTools.getPost(u, 1);

        String payLoadJson = UtilTestTools.generatePayload(postSilla);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void saveTestButValidIfProductIsNullThrowException() throws Exception {

        User u = UtilTestTools.createUser("Philip", 1);
        Post postSilla = UtilTestTools.getPost(u, 1);
        postSilla.setProduct(null);
        
        String payLoadJson = UtilTestTools.generatePayload(postSilla);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test
    public void saveTestButPriceMoreThanExpectedThrowException() throws Exception {
        User u = UtilTestTools.createUser("Philip", 1);
        Post postSilla = UtilTestTools.getPost(u, 1);
        postSilla.setPrice(20130103041.0);

        String payLoadJson = UtilTestTools.generatePayload(postSilla);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test
    public void saveTestButIdUserZeroThrowException() throws Exception {

        User u = UtilTestTools.createUser("Philip", 0);
        Post postSilla = UtilTestTools.getPost(u, 1);

        String payLoadJson = UtilTestTools.generatePayload(postSilla);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

}
