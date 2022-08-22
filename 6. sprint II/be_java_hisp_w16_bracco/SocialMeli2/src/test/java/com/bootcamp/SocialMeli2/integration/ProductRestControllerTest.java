package com.bootcamp.SocialMeli2.integration;

import com.bootcamp.SocialMeli2.dto.request.PostDto;
import com.bootcamp.SocialMeli2.dto.request.ProductDto;
import com.bootcamp.SocialMeli2.repository.IUserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestControllerTest {
    
    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void publishPostTest() throws Exception{
        PostDto postDTO = new PostDto(1,  LocalDate.now(),new ProductDto(2, "Silla Gamer", "Tecnologia", "Racer", "Black", "New"), 99, 12000.0);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadString = writer.writeValueAsString(postDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadString))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
