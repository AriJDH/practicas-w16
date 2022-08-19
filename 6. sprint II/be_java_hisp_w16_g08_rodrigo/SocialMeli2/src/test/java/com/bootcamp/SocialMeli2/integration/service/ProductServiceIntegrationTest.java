package com.bootcamp.SocialMeli2.integration.service;

import com.bootcamp.SocialMeli2.controller.ProductRestController;
import com.bootcamp.SocialMeli2.dto.request.PostDto;
import com.bootcamp.SocialMeli2.repository.IPostRepository;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.bootcamp.SocialMeli2.repository.PostRepository;
import com.bootcamp.SocialMeli2.repository.UserRepostirory;
import com.bootcamp.SocialMeli2.service.IProductService;
import com.bootcamp.SocialMeli2.service.ProductService;
import com.bootcamp.SocialMeli2.utils.TestUtils;
import com.fasterxml.jackson.core.PrettyPrinter;
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
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).registerModule(new JavaTimeModule()).writer().withDefaultPrettyPrinter();

    @Test
    @DisplayName("Post publishing test")
    public void correctPublishPostTest() throws  Exception{
        PostDto postDto = TestUtils.getOnePostDto();

        String payloadString = writer.writeValueAsString(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Test excepcion de data que no cumple restricciones")
    public void correctPublishPostTestExMethodArgumentNotValidException() throws  Exception{
        PostDto postDto = TestUtils.getOnePostDto();
        postDto.setUserId(0);
        String payloadString = writer.writeValueAsString(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("Los datos ingresados no son correctos"))
                .andExpect(jsonPath("$.errors.userId[0]").value("El id debe ser mayor a cero"));
    }

    @Test
    @DisplayName("Test excepcion de jason format incorrecto")
    public void correctPublishPostTestExHttpMessageNotReadableException() throws  Exception{
        PostDto postDto = TestUtils.getOnePostDto();
        String payloadString = writer.writeValueAsString(postDto);

        payloadString = payloadString.replace("}","a");

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value("Formato del Json incorrecto"));
    }

}
