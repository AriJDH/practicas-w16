package com.bootcamp.be_java_hisp_w16_g01.integration;

import com.bootcamp.be_java_hisp_w16_g01.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.request.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Post {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPostTest() throws Exception {
        PostDto payload = new PostDto(1, LocalDate.of(2022, 8, 22), new ProductDto(1, "Lapiz", "Test", "Test", "Test", "Test"), 1, 10.0);
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payload);


        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Publicacion creada correctamente, id: " + 1));
    }

    @Test
    void createPostInvalid() throws Exception {
        PostDto payload = new PostDto(1, LocalDate.of(2022, 8, 22), new ProductDto(1, "Lapiz", "Test", "Test", "Test & Test", "Test"), 1, 10.0);
        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payload);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("There are some fields that don't respect validations"));
    }

}
