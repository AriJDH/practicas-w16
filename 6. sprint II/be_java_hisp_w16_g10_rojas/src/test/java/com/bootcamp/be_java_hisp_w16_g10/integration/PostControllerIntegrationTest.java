package com.bootcamp.be_java_hisp_w16_g10.integration;

import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.response.FollowersCountResDTO;
import com.bootcamp.be_java_hisp_w16_g10.entity.User;
import com.bootcamp.be_java_hisp_w16_g10.repository.PostRepository;
import com.bootcamp.be_java_hisp_w16_g10.repository.UserRepository;
import com.bootcamp.be_java_hisp_w16_g10.service.PostService;
import com.bootcamp.be_java_hisp_w16_g10.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import jdk.jfr.Timestamp;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class PostControllerIntegrationTest {

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private PostService postService;

   @Autowired
   private UserService userService;

   static ObjectWriter writer;

   @BeforeAll
   public static void preSetUp() {

      writer = new ObjectMapper().registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

   }

   private ProductReqDTO product;
   private ProductReqDTO product2;
   private User user1;
   private User user2;
   private PostReqDTO post1;
   private PostReqDTO post2;
   private LocalDate date;
   private DateTimeFormatter formatter;
   private String dateFormattedString;

   @BeforeEach
   public void setUp() {

      date = LocalDate.now();
      formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      dateFormattedString = formatter.format(date);

      product = new ProductReqDTO(234, "Mouse G502", "Gamer", "Logitech", "Black", "Wireless");
      product2 = new ProductReqDTO(235, "Teclado G903", "Gamer", "Logitech", "White", "Wireless");

      user1 = new User(1, "Ale", new ArrayList<>(), new ArrayList<>());
      user2 = new User(2, "Gianni", new ArrayList<>(), new ArrayList<>());

      post1 = new PostReqDTO(1, 100, date, product, 87, 25000D);
      post2 = new PostReqDTO(1, 101, date.minusDays(1), product2, 88, 35000D);

   }

   @Test
   @DisplayName("Can create a new post")
   void shouldSaveAPost() throws Exception {

      String payloadJson = writer.writeValueAsString(post1);

      mockMvc
            .perform(MockMvcRequestBuilders.post("/products/post").contentType("application/json").content(payloadJson))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

   }

   @Test
   @DisplayName("List all post of followed seller in the last 14 days with date_desc")
   void shouldReturnAListOfPostOfFollowedSellerDateDesc() throws Exception {

      postService.save(post1);
      postService.save(post2);

      userService.findById(1).getFollowers().add(user2);
      userService.findById(2).getFollowed().add(user1);

      mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}", 2 + "/list"))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].user_id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].post_id").value(100))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].date").value(dateFormattedString))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_id").value(234))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_name").value("Mouse G502"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.type").value("Gamer"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.brand").value("Logitech"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.color").value("Black"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.notes").value("Wireless"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].category").value(87))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].price").value(25000D));

   }

   @Test
   @DisplayName("List all post of followed seller in the last 14 days with date_asc")
   void shouldReturnAListOfPostOfFollowedSellerDateAsc() throws Exception {

      dateFormattedString = formatter.format(date.minusDays(1));

      postService.save(post1);
      postService.save(post2);

      userService.findById(1).getFollowers().add(user2);
      userService.findById(2).getFollowed().add(user1);

      mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}", 2 + "/list").param("order", "date_asc"))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(2))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].user_id").value(1))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].post_id").value(101))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].date").value(dateFormattedString))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_id").value(235))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.product_name").value("Teclado G903"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.type").value("Gamer"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.brand").value("Logitech"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.color").value("White"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].product.notes").value("Wireless"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].category").value(88))
            .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].price").value(35000D));

   }

   @Test
   @DisplayName("Follow a user with posts")
   void shouldFollowAUserWithPosts() throws Exception {

      postService.save(post1);

      mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
   }

   @Test
   @DisplayName("Show followers count")
   void shouldReturnListFollowersCount() throws Exception {
      postService.save(post1);

      userService.findById(1).getFollowers().add(user2);
      userService.findById(2).getFollowed().add(user1);

      FollowersCountResDTO followersCount = FollowersCountResDTO.builder().followersCount(1).userId(1).userName("user1")
            .build();

      String jsonToCompare = writer.writeValueAsString(followersCount);

      MvcResult mockResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andReturn();

      Assertions.assertThat(mockResult.getResponse().getContentAsString().equals(jsonToCompare));

   }

   @Test
   @DisplayName("Show error message when try to list all seller posts of a user follows and that user doesn't exist ")
   void shouldReturnErrorJsonWhenTryToListANonExistingSeller() throws Exception {

      mockMvc
            .perform(MockMvcRequestBuilders.get("/products/followed/{userId}", 20 + "/list").param("order", "date_asc"))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isNotFound())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.error").value(404))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The user with id: 20 doesn't exist."));

   }

   @Test
   @DisplayName("Show error message when try to follow a user that not is a seller")
   void shouldReturnJsonErrorWhenTryToFolloANotSellerUser() throws Exception {

            mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.error").value(400))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("The user with the id 1 is not a seller."));

   }

   @Test
   @DisplayName("Show error when try to follow yourself")
   void shouldReturnJsonErrorWhenTryToFollowYourself() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.error").value(400))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Cannot follow yourself"));

   }

}
