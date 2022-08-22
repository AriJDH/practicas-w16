package com.bootcamp.be_java_hisp_w16_g04.integration;

import com.bootcamp.be_java_hisp_w16_g04.dto.ProductCreateDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.RequestCreatePublicationDTO;
import com.bootcamp.be_java_hisp_w16_g04.dto.ResponseFollowersListDTO;
import com.bootcamp.be_java_hisp_w16_g04.model.Follower;
import com.bootcamp.be_java_hisp_w16_g04.model.Product;
import com.bootcamp.be_java_hisp_w16_g04.model.Publication;
import com.bootcamp.be_java_hisp_w16_g04.model.User;
import com.bootcamp.be_java_hisp_w16_g04.repositories.FollowerRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.ProductRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.PublicationRepository;
import com.bootcamp.be_java_hisp_w16_g04.repositories.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc

public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FollowerRepository followerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PublicationRepository publicationRepository;

    RequestCreatePublicationDTO requestCreatePublicationDTO;

    private static ObjectWriter writer;


    @BeforeEach
    public void beforEach() {
        userRepository.setUsers(new ArrayList<>(Arrays.asList(new User(201, "Tannia Hernandez"), new User(202, "Juan"), new User(203, "Tomas"), new User(204, "Alejandro"))));
        followerRepository.setFollowers(new ArrayList<>(Arrays.asList(new Follower(201, 202), new Follower(201, 203), new Follower(202, 203))));
        productRepository.setProducts(new ArrayList<>(Arrays.asList(new Product(100, "Silla gamer", "Gamer", "Racer", "Negro", "usado"),new Product(200, "Nevera", "Linea blanca", "Samsung", "Blanca", "usado"))));

        LocalDate date1 = LocalDate.parse(LocalDate.now().minusDays(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate date2 = LocalDate.parse(LocalDate.now().minusDays(12).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        publicationRepository.setPublications(new ArrayList<>(Arrays.asList(new Publication(1, 201, date1, 100, 100, 150.0),new Publication(2, 202, date2, 200, 400, 538.8))));
    }

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @Test
    void testGivenValidUserIdGetCountNumberFollowers() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 201))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(201))
                .andExpect(jsonPath("$.user_name").value("Tannia Hernandez"))
                .andExpect(jsonPath("$.followers_count").value(2))
                .andReturn();
         Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void testGivenAnInvalidUserIdThrowExceptionMessage() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 430))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("User Not Found with User Id: 430"));
    }

    @Test
    void testGivenValidUserIdGetFollowersList() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 201)
                .param("order", "name_asc"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(201))
                .andExpect(jsonPath("$.user_name").value("Tannia Hernandez"))
                .andExpect(jsonPath("$.followers.size()").value(2))
                .andReturn();
        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    void testGivenValidUserIdGetFollowedList() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 203)
                .param("order", "name_asc"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(203))
                .andExpect(jsonPath("$.user_name").value("Tomas"))
                .andExpect(jsonPath("$.followed.size()").value(2))
                .andReturn();
        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    public void testCreatePublication() throws Exception {

        requestCreatePublicationDTO = new RequestCreatePublicationDTO(402,LocalDate.now(),new ProductCreateDTO(1,"silla","gamer","new collection","blue","great"),200,1200);

        String payloadJson = writer.writeValueAsString(requestCreatePublicationDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.title").value("Success"))
                .andExpect(jsonPath("$.message").value("All ok"));
    }

    @Test
    void testGivenValidUserIdGetProductList() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 203)
                .param("order", "date_asc"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(203))
                .andExpect(jsonPath("$.posts.size()").value(2))
                .andExpect(jsonPath("$.posts[0].post_id").value(2))
                .andExpect(jsonPath("$.posts[1].product.product_name").value("Silla gamer"))
                .andReturn();
        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    public void testUnfollowUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}",203,201)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Unfollow successful"));
    }

    @Test
    public void testfollowAlreadyUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",203,201)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("The user already follows the seller"));
    }

    @Test
    public void testfollowUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",204,201)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Successful follow-up"));
    }
}
