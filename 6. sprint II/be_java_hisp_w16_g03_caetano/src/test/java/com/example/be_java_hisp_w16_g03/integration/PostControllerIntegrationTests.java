package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.FollowerCountDTO;
import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.example.be_java_hisp_w16_g03.dto.UserDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;



    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();


    }


    @Test
    public void testValidFollowerCountDTO() throws Exception {

        FollowerCountDTO test = new FollowerCountDTO(2, "emanuel", 3);

        String result = writer.writeValueAsString(test);
        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(result);

        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/users/{userId}/followers/count", 2))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(expectedJson)
                .andExpect(expectedStatus);

    }

    @Test
    public void testAddPost() throws Exception {
        PostDTO request = new PostDTO(1,LocalDate.now(),ProductDTO.builder()
                .productId(1)
                .productName("test")
                .type("testtype")
                .color("testcolor")
                .notes("testnotes")
                .brand("testBrand")
                .build()
                ,3,500.0);
        String requestString = writer.writeValueAsString(request);
        ResultMatcher expectedStatus = status().isOk();


        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType("application/json")
                        .content(requestString))
                .andExpect(expectedStatus).andReturn();

    }



    @Test
    public void NotfollowedsTest() throws Exception {


        ResultMatcher expectedStatus = status().isBadRequest();


        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", 4,1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus);

    }



}
