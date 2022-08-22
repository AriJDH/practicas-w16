package com.bootcamp.be_java_hisp_w16_g10.controller;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.util.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTestIntegrados {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Testing register post")
    void shouldRegisterPost() throws Exception{
        PostReqDTO post = Mapper.genetarePostReqDTO();
        ObjectWriter writer =  new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String payloadJSON = writer.writeValueAsString(post);
        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJSON))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Testing validation of DTO")
    void shouldThrowMethodArgumentNotValidExceptionWhenValidatePost() throws Exception{
        PostReqDTO post = Mapper.genetarePostReqDTO();
        post.setUserId(0);
        ObjectWriter writer =  new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
        String payloadJSON = writer.writeValueAsString(post);
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJSON))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    @DisplayName("Testing get followed products")
    void shouldGetListFollowed() throws Exception{
        mockMvc.perform(get("/products/followed/{userId}/list",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Testing get followed products when user not exists")
    void shouldThrowNotFoundException() throws Exception{
        mockMvc.perform(get("/products/followed/{userId}/list",0))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }
}