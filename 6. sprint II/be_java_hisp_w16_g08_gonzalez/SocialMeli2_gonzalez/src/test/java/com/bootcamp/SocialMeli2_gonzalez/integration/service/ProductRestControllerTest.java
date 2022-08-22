package com.bootcamp.SocialMeli2_gonzalez.integration.service;

import com.bootcamp.SocialMeli2_gonzalez.dto.request.PostDto;
import com.bootcamp.SocialMeli2_gonzalez.utils.TestUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductRestControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Test que verifica la creacion de un nuevo post")
    public void publishPostTest() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        PostDto postDto = TestUtils.getOnePostDto();

        String payloadTest = writer.writeValueAsString(postDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post").
                contentType(MediaType.APPLICATION_JSON)
                .content(payloadTest))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
