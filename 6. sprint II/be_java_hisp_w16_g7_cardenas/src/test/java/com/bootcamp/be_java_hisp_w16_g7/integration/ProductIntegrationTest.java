package com.bootcamp.be_java_hisp_w16_g7.integration;

import com.bootcamp.be_java_hisp_w16_g7.dto.PostDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.RecentPostsDTO;
import com.bootcamp.be_java_hisp_w16_g7.dto.ResponsePostDTO;
import com.bootcamp.be_java_hisp_w16_g7.entity.User;
import com.bootcamp.be_java_hisp_w16_g7.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w16_g7.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    IUserRepository repo;

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .registerModule(new JavaTimeModule());

    @BeforeEach
    public void setUp() {
        User user1 = repo.findUserById(1111);
        User user2 = repo.findUserById(2222);

        user1.getFollowers().add(user2);
        user2.getFollows().add(user1);
    }

    @AfterEach
    public void clear() {
        User user1 = repo.findUserById(1111);
        User user2 = repo.findUserById(2222);

        user1.getFollowers().remove(user2);
        user2.getFollows().remove(user1);
        user1.setPosts(new ArrayList<>());
    }

    @Test
    public void createPost() throws Exception {
        PostDTO post = TestUtil.createPostDto();

        String payload = mapper.writeValueAsString(post);

        // Test create post bad input
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("HttpMessageNotReadableException"));

        ProductDTO product = TestUtil.CreateProductDto();
        post.setProduct(product);

        payload = mapper.writeValueAsString(post);

        // Test create post ok
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Post created successfully"));
    }

    @Test
    public void recentPosts() throws Exception {
        PostDTO post = TestUtil.createPostDto();
        ProductDTO product = TestUtil.CreateProductDto();
        post.setProduct(product);

        String payload = mapper.writeValueAsString(post);

        // Create recent post
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("Post created successfully"));


        // Get recent posts ok
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2222))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.user_id").value(2222))
                .andReturn();

        RecentPostsDTO response = mapper.readValue(result.getResponse().getContentAsString(), RecentPostsDTO.class);
        Assertions.assertEquals(product, response.getResponsePostDTOS().get(0).getProduct());

        // Get recent posts not found
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 5555))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.title").value("User Not Found"))
                .andReturn();
    }
}
