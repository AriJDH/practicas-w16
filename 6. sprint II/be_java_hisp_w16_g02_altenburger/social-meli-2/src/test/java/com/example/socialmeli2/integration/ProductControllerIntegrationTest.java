package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.ProductDto;
import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.Product;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.service.UserService;
import com.example.socialmeli2.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private IRepository<Post> postRepository;
    @Autowired
    private IRepository<User> userRepository;
    @Autowired
    private UserService userService;

    @BeforeEach
    public void initialize(){

        userRepository.dropAll();
        postRepository.dropAll();

        Product product1 = Util.getProduct(1, "Teclado");
        Product product2 = Util.getProduct(2, "Mouse");
        Product product3 = Util.getProduct(2, "Notebook");
        Product product4 = Util.getProduct(2, "Parlantes");
        Product product5 = Util.getProduct(2, "Silla");
        Post post1 = Util.getPost(1, 1, product1, LocalDate.now());
        Post post2 = Util.getPost(2, 1, product2, LocalDate.now().minusDays(7));
        Post post3 = Util.getPost(3, 1, product3, LocalDate.now().minusDays(20));
        Post post4 = Util.getPost(4, 2, product4, LocalDate.now().minusDays(25));
        Post post5 = Util.getPost(5, 2, product5, LocalDate.now().minusDays(3));

        postRepository.add(post1);
        postRepository.add(post2);
        postRepository.add(post3);
        postRepository.add(post4);
        postRepository.add(post5);

        User user1 = new User(0, "gonza", new ArrayList<User>(), new ArrayList<User>());
        User user2 = new User(0, "sabri", new ArrayList<User>(), new ArrayList<User>());
        User user3 = new User(0, "pame", new ArrayList<User>(), new ArrayList<User>());
        User user4 = new User(0, "mateo", new ArrayList<User>(), new ArrayList<User>());
        User user5 = new User(0, "erika", new ArrayList<User>(), new ArrayList<User>());
        User user6 = new User(0, "claudio", new ArrayList<User>(), new ArrayList<User>());

        userRepository.add(user1);
        userRepository.add(user2);
        userRepository.add(user3);
        userRepository.add(user4);
        userRepository.add(user5);
        userRepository.add(user6);
    }
    @Test
    public void testAddPostWithBadRequest() throws Exception{
        String jsonPost="{\n" +
                "    \"user_id\": 1,\n" +
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
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON).content(jsonPost))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El campo no puede poseer caracteres especiales."))
                .andReturn();
    }
    @Test
    public void testAddPost() throws Exception{
        PostDto postDto = new PostDto();
        postDto.setUserId(1);
        postDto.setDate(LocalDate.of(2022,8,1));
        postDto.setProduct(new ProductDto(1,"Silla Gamer", "Gamer", "Racer", "Black","Special Edition"));
        postDto.setCategory(100);
        postDto.setPrice(1500.5);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payLoadPostDtoJson = writer.writeValueAsString(postDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadPostDtoJson))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk());
    }
    @Test
    public void testGetFollowedPostLastTwoWeeks() throws Exception{
        userService.addFollower(2,1);
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", "2"))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.posts[0].post_id").value(1))
                .andExpect(jsonPath("$.posts[1].post_id").value(2))
                .andReturn();
    }

}
