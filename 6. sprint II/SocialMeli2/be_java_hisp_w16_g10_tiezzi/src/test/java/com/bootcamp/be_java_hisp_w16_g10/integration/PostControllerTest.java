package com.bootcamp.be_java_hisp_w16_g10.integration;

import com.bootcamp.be_java_hisp_w16_g10.dto.request.PostReqDTO;
import com.bootcamp.be_java_hisp_w16_g10.dto.request.ProductReqDTO;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldSavePost() throws Exception {
        PostReqDTO postReqDTO = PostReqDTO.builder()
                .idPost(1111)
                .userId(1)
                .date(LocalDate.now())
                .product(ProductReqDTO.builder()
                        .productId(1234)
                        .productName("Ukelele")
                        .type("Music")
                        .brand("Ohana")
                        .color("Brown")
                        .notes("New")
                        .build())
                .category(99)
                .price(1000.0)
                .build();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(postReqDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldRaiseBadRequestWhenSavePostWithNoUserId() throws Exception {
        PostReqDTO postReqDTO = PostReqDTO.builder()
                .idPost(1111)
                .date(LocalDate.now())
                .product(ProductReqDTO.builder()
                        .productId(1234)
                        .productName("Ukelele")
                        .type("Music")
                        .brand("Ohana")
                        .color("Brown")
                        .notes("New")
                        .build())
                .category(99)
                .price(1000.0)
                .build();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(postReqDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.fields[0].name").value("userId"));
    }

    @Test
    public void shouldRaiseBadRequestWhenTryingToFollowTheUserWithNoPosts() throws Exception {
        Integer user1 = 1;
        Integer user2 = 2;

        this.mockMvc.perform(MockMvcRequestBuilders.post(String.format("/users/%s/follow/%s", user1, user2)))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(String.format("The user with the id %s is not a seller.", user2)));
    }
}
