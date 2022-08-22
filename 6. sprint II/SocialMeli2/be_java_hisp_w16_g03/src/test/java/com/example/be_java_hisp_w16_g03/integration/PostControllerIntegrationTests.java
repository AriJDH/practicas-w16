package com.example.be_java_hisp_w16_g03.integration;

import com.example.be_java_hisp_w16_g03.dto.PostDTO;
import com.example.be_java_hisp_w16_g03.dto.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void beforEach() {
        //Codigo que se ejecuta de por medio de cada test.
    }

    @Test
    void addNewPostSuccessfully() throws Exception {
        // Arrange
        PostDTO postDTO = new PostDTO();
        ProductDTO productDTO = new ProductDTO();
        postDTO.setUserId(2);
        postDTO.setDate(LocalDate.of(2022,5,1));
        postDTO.setCategory(100);
        postDTO.setPrice(1500d);
        productDTO.setProductId(1);
        productDTO.setProductName("Silla");
        productDTO.setType("tipo");
        productDTO.setBrand("marca");
        productDTO.setColor("Black");
        productDTO.setNotes("notes");
        postDTO.setProduct(productDTO);
        String postRequestJson = writer.writeValueAsString(postDTO);


        ResultMatcher expectedStatus = status().isOk();
        //ResultMatcher expectedJson = content().json(new ResponseEntity<PostDTO>(HttpStatus.OK));
        //ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                "/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postRequestJson);

        // Act & Assert
        var res = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(expectedStatus)
                .andReturn();

    }
}
