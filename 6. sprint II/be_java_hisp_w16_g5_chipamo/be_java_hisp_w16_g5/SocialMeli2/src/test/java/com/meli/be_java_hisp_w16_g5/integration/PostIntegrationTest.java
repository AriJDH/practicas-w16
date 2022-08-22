package com.meli.be_java_hisp_w16_g5.integration;

import com.meli.be_java_hisp_w16_g5.dto.PostDto;
import com.meli.be_java_hisp_w16_g5.dto.PostsByUserDto;
import com.meli.be_java_hisp_w16_g5.entity.Post;
import com.meli.be_java_hisp_w16_g5.entity.Product;
import com.meli.be_java_hisp_w16_g5.entity.User;
import com.meli.be_java_hisp_w16_g5.repository.PostRepository;
import com.meli.be_java_hisp_w16_g5.repository.ProductRepository;
import com.meli.be_java_hisp_w16_g5.repository.UserRepository;
import com.meli.be_java_hisp_w16_g5.util.Util;
import com.meli.be_java_hisp_w16_g5.util.UtilTestTools;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    private static String BASE_URL ="/products";

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private MockMvc mockMvc;

    private User user;
    

    @BeforeEach
    public void setUp() {

        user = UtilTestTools.createUser("Gae", 1);
        User following = UtilTestTools.createCompletedUser("Johannes", 2);
        User user2 = UtilTestTools.createUser("Sebastian", 4);
        List<User> users = List.of(following, user, user2);
        this.userRepository.save(users);

        user.getFollowing().add(following);

        List<Post> posts = UtilTestTools.getListProductsForUserByDays(following, 4, 3, 7, 19);
        following.setPosts(posts);
        postRepository.save(posts);

        Product productSilla = new Product(1,"Silla gamer","Silla","Lagotech","Black","Silla gamer lagotech negra");
        Product productMesa = new Product(2,"Mesa gamer","mesa","Lagotech","Black","Silla gamer lagotech negra");
        Product productMouse = new Product(3,"Mouse gamer","mouse","Lagotech","Black","Silla gamer lagotech negra");

        List<Product> products = List.of(productSilla, productMesa, productMouse);

        this.productRepository.save(products);
    }

    @Test
    public void savePost() throws Exception {
        User u = UtilTestTools.createUser("Sebastian", 4);
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

        User u = UtilTestTools.createUser("Sebastian", 4);
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
        User u = UtilTestTools.createUser("Sebastian", 4);
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

        User u = UtilTestTools.createUser("Sebastian", 0);
        Post postSilla = UtilTestTools.getPost(u, 1);

        String payLoadJson = UtilTestTools.generatePayload(postSilla);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payLoadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test 
    public void getFollowedProducts() throws Exception{
        //Arrange

        List<PostDto> posts = UtilTestTools.sortFollowedPosts(user, 0);
        PostsByUserDto postsByUserDto = new PostsByUserDto(user.getUserId(), posts);

        String payLoadJson = UtilTestTools.generateNoPrettyPayload(postsByUserDto);

        //Act
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/followed/{userId}/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(response.getResponse().getContentAsString(), payLoadJson);
    }

    @Test 
    public void getFollowedProductsAscOrder() throws Exception{
        //Arrange
        String order = "date_asc";
        String tag = "date";
        Integer sortCondition = Util.getSortCondition(order, tag);

        List<PostDto> posts = UtilTestTools.sortFollowedPosts(user, sortCondition);

        PostsByUserDto postsByUserDto = new PostsByUserDto(user.getUserId(), posts);
        String payLoadJson = UtilTestTools.generateNoPrettyPayload(postsByUserDto);

        //Act
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/followed/{userId}/list",1).queryParam("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(response.getResponse().getContentAsString(), payLoadJson);
    }

    @Test 
    public void getFollowedProductsDescOrder() throws Exception{
        //Arrange
        String order = "date_desc";
        String tag = "date";
        Integer sortCondition = Util.getSortCondition(order, tag);

        List<PostDto> posts = UtilTestTools.sortFollowedPosts(user, sortCondition);

        PostsByUserDto postsByUserDto = new PostsByUserDto(user.getUserId(), posts);
        String payLoadJson = UtilTestTools.generateNoPrettyPayload(postsByUserDto);

        //Act
        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/followed/{userId}/list",1).queryParam("order", order))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertEquals(response.getResponse().getContentAsString(), payLoadJson);
    }
}
