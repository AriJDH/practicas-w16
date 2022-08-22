package com.bootcamp.be_java_hisp_w16_g10.integration;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.util.Factory;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void PostRouteShouldSaveThePost() throws Exception {
        PostReqDTO post = Factory.generateProductReqDTO();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk());
    }
    @Test
    public void PostRouteShouldRaiseAnErrorIfAFieldIsMissing() throws Exception {
        PostReqDTO post = PostReqDTO.builder()
                .idPost(666)
                .date(LocalDate.now())
                .product(ProductReqDTO.builder()
                        .productId(111)
                        .productName("Termo")
                        .type("salud")
                        .brand("Explorer")
                        .color("verde")
                        .notes("Mantiene el agua caliente 24 horas")
                        .build())
                .category(5)
                .userId(1)
                .build();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer()
                .withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders
                        .post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fields[0].name").value("price"));
    }
}
