package com.bootcamp.SocialMeli2.integration;

import com.bootcamp.SocialMeli2.dto.request.PostDto;
import com.bootcamp.SocialMeli2.exception.OrderNotPossibleException;
import com.bootcamp.SocialMeli2.exception.UserNotFoundException;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .registerModule(new JavaTimeModule())
            .writer().withDefaultPrettyPrinter();

    @Test
    @DisplayName("\"/products/post\" - Post publishing test")
    public void correctPublishPostTest() throws Exception {
        PostDto postDto = TestUtils.getOnePostDto(1);
        String payloadString = writer.writeValueAsString(postDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("\"/products/post\" - BadUserID")
    public void PublishPostWithErrorOnUserIdTest() throws Exception {
        PostDto postDto = TestUtils.getOnePostDto(1);
        postDto.setUserId(999);
        String payloadString = writer.writeValueAsString(postDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException));
    }

    @Test
    @DisplayName("\"/products/post\" - Post publishing test")
    public void PublishPostWithPayloadErrorTest() throws Exception {
        PostDto postDto = TestUtils.getOnePostDto(1);
        String payloadString = writer.writeValueAsString(postDto);
        payloadString = payloadString.replace("{", "a");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof HttpMessageNotReadableException));
    }
    @Test
    @DisplayName("\"/products/post\" - Post publishing test")
    public void PublishPostWithBadNameTest() throws Exception {
        PostDto postDto = TestUtils.getOnePostDto(1);
        String payloadString = writer.writeValueAsString(postDto);
        payloadString = payloadString.replace("Mouse", "Silla & escritorio");
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> Assertions.assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

}