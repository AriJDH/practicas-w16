package com.meli.obtenerdiploma.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetScoresIsOk() throws Exception{
        List<SubjectDTO> subjectsDTO = new ArrayList<>(List.of(new SubjectDTO("Matemática",9D),
                new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D)));

        StudentDTO response = new StudentDTO(1l, "Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",7.333333333333333, subjectsDTO );

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.averageScore").value(7.333333333333333))
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar."))
                .andReturn();

    }
}
