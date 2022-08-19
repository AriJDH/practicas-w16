package com.bootcamp.be_java_hisp_w16_g01.integration;

import com.bootcamp.be_java_hisp_w16_g01.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g01.utils.FactoryPost;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addPostOkTest() throws Exception{
        PostDto request = FactoryPost.generatePostDTO();

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule()).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post",1)
                .contentType("application/json").
                content(writer.writeValueAsString(request)))
                .andDo(print()).andExpect(status().isOk()).
                andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    public void addPostInvalidArgTest() throws Exception{
        PostDto request = FactoryPost.generateInvalidPostDTO();

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule()).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post",1)
                        .contentType("application/json").
                        content(writer.writeValueAsString(request)))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("There are some fields that don't respect validations"))
                .andReturn();

    }

    @Test
    public void getFollowedPostsInvalidTest() throws  Exception{

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/-1/list?order=date_asc",-1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("constraintViolationException"))
                .andReturn();
    }

    @Test
    public void getFollowedPostsInvalidUserTest() throws  Exception{

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/44/list?order=date_asc",-1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad request"))
                .andReturn();
    }

    @Test
    public void getFollowedPostsNullUserTest() throws  Exception{

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/null/list?order=date_asc",-1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Argument missmatch"))
                .andReturn();
    }

    @Test
    public void getFollowedNoOrderTest() throws  Exception{

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list",-1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Bad request"))
                .andReturn();
    }
}
