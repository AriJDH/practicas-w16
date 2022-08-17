package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.integration.dto.StudentDtoTest;
import com.meli.obtenerdiploma.integration.dto.SubjectDtoTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private void setUp() throws Exception {

        SubjectDtoTest geographic = new SubjectDtoTest("Geografia", 8D);
        SubjectDtoTest literature = new SubjectDtoTest("Literatura", 8D);
        SubjectDtoTest science = new SubjectDtoTest("Ciencias Naturales", 8D);
        StudentDtoTest payloadDTO = new StudentDtoTest(1L, "George", null, null,
                List.of(geographic, literature, science));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @Order(1)
    void analyzeScoresTest() throws Exception {
        setUp();
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.studentName").isString())
                .andExpect(jsonPath("$.message").isString());
    }

    @Test
    @Order(2)
    void analyzeScoresExceptionTest() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}", 20))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description")
                        .value("El alumno con Id 20 no se encuetra registrado."));
    }

    @Test
    @Order(3)
    void analyzeScoresBadRequestTest() throws Exception {
        this.mockMvc.perform(get("/analyzeScores/{studentId}", "A"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result ->
                        assertTrue(result.getResolvedException() instanceof MethodArgumentTypeMismatchException));
    }
}






