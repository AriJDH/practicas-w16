package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void calculateAverageScore() throws Exception {
        var idToSearch = 1;

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", idToSearch))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9));
    }

    @Test
    void calculateAverageScoreStudentNotFound() throws Exception {
        var idToSearch = 3;


        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", idToSearch))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id " + idToSearch + " no se encuetra registrado."));
    }

    @Test
    void registerNewStudent() throws Exception{
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math",6.0));
        var student = new StudentDTO(1L,"Javier","",null,subjects);

        var writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payload = writer.writeValueAsString(student);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post(
                                "/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isOk());
    }


    @Test
    void registerNewStudentWithInvalidName() throws Exception{
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Math",6.0));
        var student = new StudentDTO(1L,"javier","",null,subjects);

        var writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payload = writer.writeValueAsString(student);

        this.mockMvc
                .perform(MockMvcRequestBuilders.post(
                                "/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El nombre del estudiante debe comenzar con mayuscula."));
    }
}
