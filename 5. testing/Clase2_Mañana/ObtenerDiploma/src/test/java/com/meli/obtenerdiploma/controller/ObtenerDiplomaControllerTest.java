package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    private String payloadJson;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void createUserJson() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("Math", 10.0);
        SubjectDTO english = new SubjectDTO("English", 10.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 10.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(1L, "Carlos", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        payloadJson = (writer).writeValueAsString(payloadDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson));
    }

    @Test
    void analyzeScores() throws Exception {
       this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1L))
               .andDo(print()).andExpect(status().isOk())
               .andExpect(content().contentType("application/json"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Carlos ha obtenido un promedio de 10.00. Felicitaciones!"))
               .andReturn();
    }
    @Test
    void analyzeEmptyScoresTest() throws Exception {
        Long variable = 40L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", variable)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id "+ variable + " no se encuetra registrado."));
    }
}