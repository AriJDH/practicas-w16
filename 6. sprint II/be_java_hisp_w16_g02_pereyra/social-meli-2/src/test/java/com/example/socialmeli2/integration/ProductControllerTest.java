package com.example.socialmeli2.integration;

import com.example.socialmeli2.dto.PostDto;
import com.example.socialmeli2.dto.PostLastTwoWeeksDto;
import com.example.socialmeli2.dto.PostListLastTwoWeeksDto;
import com.example.socialmeli2.dto.ProductDto;
import com.example.socialmeli2.model.Post;
import com.example.socialmeli2.model.Product;
import com.example.socialmeli2.model.User;
import com.example.socialmeli2.repository.IRepository;
import com.example.socialmeli2.repository.PostRepository;
import com.example.socialmeli2.service.IUserService;
import com.example.socialmeli2.util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.time.LocalDate;
import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRepository<Post> postRepository;
    @Autowired
    private IRepository<User> userRepository;
    @Autowired
    private MockMvc mockMvc;

    PostListLastTwoWeeksDto postListLastTwoWeeksDto;
    @BeforeEach
    public void initialize(){

        userRepository.reset();
        postRepository.reset();

        User user1 = Util.getUser(1, "Gonza");
        User user2 = Util.getUser(2, "Eri");

        userRepository.add(user1);
        userRepository.add(user2);

        Product product1 = Util.getProduct(1, "Teclado");
        Product product2 = Util.getProduct(2, "Mouse");
        Product product3 = Util.getProduct(3, "Notebook");
        Post post1 = Util.getPost(1, 1, product1, LocalDate.now());
        Post post2 = Util.getPost(2, 1, product2, LocalDate.now().minusDays(7));
        Post post3 = Util.getPost(3, 1, product3, LocalDate.now().minusDays(3));

        postRepository.add(post1);
        postRepository.add(post2);
        postRepository.add(post3);

        userService.addFollower(2, 1);

    }

    @Test
    public void addPostTest() throws Exception{
        PostDto postDto = new PostDto();
        postDto.setUserId(1);
        postDto.setDate(LocalDate.of(2022, 8, 1));
        postDto.setProduct(new ProductDto(1, "random", "gamer", "gamer", "red", "Todo ok"));
        postDto.setCategory(1);
        postDto.setPrice(20000.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String postDtoPayload = writer.writeValueAsString(postDto);

         mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDtoPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getFollowedPostLastTwoWeeksValidTest() throws Exception{
        PostLastTwoWeeksDto postLastTwoWeeksDto = new PostLastTwoWeeksDto();
        postLastTwoWeeksDto.setPostId(1);
        postLastTwoWeeksDto.setUserId(1);
        postLastTwoWeeksDto.setDate(LocalDate.now());
        postLastTwoWeeksDto.setProduct(new ProductDto(1, "random", "gamer", "gamer", "red", "Todo ok"));
        postLastTwoWeeksDto.setCategory(1);
        postLastTwoWeeksDto.setPrice(20000.0);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String postDtoPayload = writer.writeValueAsString(postLastTwoWeeksDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postDtoPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getFollowedPostLastTwoWeeksTestWithOutRestriction() throws Exception{

        PostListLastTwoWeeksDto postListLastTwoWeeksDto = new PostListLastTwoWeeksDto();
        postListLastTwoWeeksDto.setUserId(2);
        postListLastTwoWeeksDto.setPosts(Arrays.asList(
                new PostLastTwoWeeksDto(1, 1, LocalDate.now(), new ProductDto(1, "Teclado", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(2, 1, LocalDate.now().minusDays(7), new ProductDto(2, "Mouse", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(3, 1, LocalDate.now().minusDays(3), new ProductDto(3, "Notebook", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responsePostListLastTwoWeeksDtoJson = writer.writeValueAsString(postListLastTwoWeeksDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", "2")
                ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responsePostListLastTwoWeeksDtoJson, mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void getFollowedPostLastTwoWeeks_DescTest() throws Exception{

        PostListLastTwoWeeksDto postListLastTwoWeeksDto = new PostListLastTwoWeeksDto();
        postListLastTwoWeeksDto.setUserId(2);
        postListLastTwoWeeksDto.setPosts(Arrays.asList(
                new PostLastTwoWeeksDto(1, 1, LocalDate.now(), new ProductDto(1, "Teclado", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(3, 1, LocalDate.now().minusDays(3), new ProductDto(3, "Notebook", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
        new PostLastTwoWeeksDto(2, 1, LocalDate.now().minusDays(7), new ProductDto(2, "Mouse", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseListLastTwoWeek = writer.writeValueAsString(postListLastTwoWeeksDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", "2").param("order", "date_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseListLastTwoWeek, mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void getFollowedPostLastTwoWeeks_AscTest() throws Exception{

        PostListLastTwoWeeksDto postListLastTwoWeeksDto = new PostListLastTwoWeeksDto();
        postListLastTwoWeeksDto.setUserId(2);
        postListLastTwoWeeksDto.setPosts(Arrays.asList(

                new PostLastTwoWeeksDto(2, 1, LocalDate.now().minusDays(7), new ProductDto(2, "Mouse", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(3, 1, LocalDate.now().minusDays(3), new ProductDto(3, "Notebook", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0),
                new PostLastTwoWeeksDto(1, 1, LocalDate.now(), new ProductDto(1, "Teclado", "Generic", "Generic", "Generic", "Generic"), 1, 15000.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseListLastTwoWeek = writer.writeValueAsString(postListLastTwoWeeksDto);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", "2").param("order", "date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(responseListLastTwoWeek, mvcResult.getResponse().getContentAsString());
    }

}