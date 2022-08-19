package com.example.be_java_hisp_w16_g09.integration;

import com.example.be_java_hisp_w16_g09.dto.MessageDto;
import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.ProductDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class PostIntegrationTests {

    @Autowired
    private MockMvc application;

    private ObjectWriter objectWriter;

    @BeforeEach
    void setUp() {
        objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    void shouldCreateAPost() throws Exception {
        ProductDto productDto = new ProductDto(1, "Camisa", "Ropa", "Polo", "Blue", "Notas");
        PostDto postDto = new PostDto(1, 1, LocalDate.now(), productDto, 1, 150d);
        var postAsJson = objectWriter.writeValueAsString(postDto);

        application.perform(
                        post("/products/post")
                                .content(postAsJson)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andDo(print())
                        .andExpect(status().isOk());
    }

    @Test
    void shouldNotCreatePostForNonRegisteredUser() throws Exception {
        var userId = 99999;
        ProductDto productDto = new ProductDto(1, "Camisa", "Ropa", "Polo", "Blue", "Notas");
        PostDto postDto = new PostDto(userId, 1, LocalDate.now(), productDto, 1, 150d);
        var postAsJson = objectWriter.writeValueAsString(postDto);

        var response =
                application.perform(
                        post("/products/post")
                                .content(postAsJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        var parsedErrorMessage = new ObjectMapper().readValue(response.getResponse().getContentAsString(), MessageDto.class);

        var expectedMessage = new MessageDto(String.format("User with id: %d not found",userId));

        Assertions.assertThat(parsedErrorMessage).isEqualTo(expectedMessage);
    }

}
