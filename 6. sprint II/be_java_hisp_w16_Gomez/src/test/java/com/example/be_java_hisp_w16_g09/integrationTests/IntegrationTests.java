package com.example.be_java_hisp_w16_g09.integrationTests;

import com.example.be_java_hisp_w16_g09.dto.PostDto;
import com.example.be_java_hisp_w16_g09.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper writer = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

    @Test
    @DisplayName("Crear un nuevo post")
    void createPost() throws Exception {

        var userSellerId = 2;

        ProductDto product = new ProductDto(1, "Silla escritorio", "Casa", "Patito", "negro", "meh");
        PostDto post = new PostDto(userSellerId, 22, LocalDate.now(), product, 1, 2500);

        String body = writer.writeValueAsString(post);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Ver la lista de vendedores seguidos")
    void followed() throws Exception {

        var userId = 1;
        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.following").isArray())
                .andExpect(jsonPath("$.following", hasSize(1)))
                .andExpect(jsonPath("$.following[0].user_id", is(2)))
                .andExpect(jsonPath("$.following[0].user_name", is("Nicolas")));

    }


}
