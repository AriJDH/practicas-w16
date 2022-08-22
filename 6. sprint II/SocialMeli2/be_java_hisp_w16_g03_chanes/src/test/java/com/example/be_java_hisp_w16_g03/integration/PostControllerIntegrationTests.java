package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.example.be_java_hisp_w16_g03.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IUserService userService;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .registerModule(new JavaTimeModule())
            .writer().withDefaultPrettyPrinter();

    @Test
    void addPostThrowsException() throws Exception {

        PostDTO payloadDTO = new PostDTO();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Payload's Field Not Valid Exception"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("There are some fields that don't respect validations"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors.date").value("La fecha no puede estar vacía"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors.price").value("El campo no puede estar vacío"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors.category").value("El campo no puede estar vacío"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.errors.userId").value("El id no puede estar vacío"));

    }

    @Test
    void addPost() throws Exception {

        PostDTO payloadDTO = PostDTO.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(ProductDTO.builder()
                        .productId(1)
                        .productName("Producto")
                        .type("Tipo")
                        .color("Rojo")
                        .brand("Marca")
                        .notes("Ninguna").build())
                .category(1)
                .price(11.11)
                .build();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());


        Assertions.assertEquals(userService.getUser(payloadDTO.getUserId()).getPosts().size(), 1);
    }

}