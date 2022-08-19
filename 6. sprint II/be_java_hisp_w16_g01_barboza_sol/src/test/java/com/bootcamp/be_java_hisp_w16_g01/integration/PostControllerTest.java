package com.bootcamp.be_java_hisp_w16_g01.integration;

import com.bootcamp.be_java_hisp_w16_g01.dto.request.PostDto;
import com.bootcamp.be_java_hisp_w16_g01.dto.request.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDate;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createPostTest() throws Exception {
        ProductDto productDto = new ProductDto(2, "Termo", "Metalico", "Stanley", "Verde", null);
        PostDto postDto = new PostDto(3, LocalDate.now(), productDto, 100, 2500.00);
        PostDto payloadDTO = postDto;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Publicacion creada correctamente")));
    }

    @Test
    public void createPostIdNullExceptionTest() throws Exception {
        ProductDto productDto = new ProductDto(null, "Termo", "Metalico", "Stanley", "Verde", null);
        PostDto postDto = new PostDto(3, LocalDate.now(), productDto, 100, 2500.00);
        PostDto payloadDTO = postDto;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("There are some fields that don't respect validations"));
    }

    @Test
    public void createPostMessageNotReadableExceptionTest() throws Exception {
        String productDto = "1, Termo, Metalico, Stanley, Verde, null";
        String payloadDTO = "3, LocalDate.of(2022, 10, 10)" + productDto + " , 100, 2500.00";

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/products/post").contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof HttpMessageNotReadableException));
    }

    @Test
    public void getFollowedPostsOrderTest() throws Exception {
        String order = "date_asc";
        Integer id = 1;
        this.mockMvc.perform(get("/products/followed/{id}/list", id)
                        .param("order", order)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(1));
    }

    @Test
    public void getFollowedPostsOrderExceptionTest() throws Exception {
        String order = "a";
        Integer id = 1;
        this.mockMvc.perform(get("/products/followed/{id}/list", id)
                        .param("order", order)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("El orden indicado no es correcto."));
    }

    @Test
    public void getFollowedPostsWithoutOrderTest() throws Exception {
        Integer id = 1;
        this.mockMvc.perform(get("/products/followed/{id}/list", id)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("No hay un orden indicado"));
    }

    @Test
    public void getFollowedPostsOrderWithTypeIdInvalidExceptionTest() throws Exception {
        String id = "user1";
        String order = "asc";
        this.mockMvc.perform(get("/products/followed/{id}/list", id)
                        .param("order", order)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentTypeMismatchException));
    }
}
