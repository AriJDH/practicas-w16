package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.DecimalFormat;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @AfterEach
    void tearDown() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    void getScoreByNonExistentStudentId() throws Exception {
        Integer id = 1;
        ErrorDTO expectedError = new ErrorDTO("StudentNotFoundException", "El alumno con Id " + id + " no se encuetra registrado.");

        String errorDTOAsJson = writer.writeValueAsString(expectedError);

        MvcResult response =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", id))
                        .andDo(print())
                        .andExpect(status().isNotFound())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        Assertions
                .assertThat(response.getResponse().getContentAsString())
                .isEqualTo(errorDTOAsJson);
    }

    @Test
    void getScoreByStudentId() throws Exception {
        postStudent();

        MvcResult response =
                mockMvc
                        .perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1l))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();

        StudentDTO studentDTO = new ObjectMapper().readValue(response.getResponse().getContentAsString(), StudentDTO.class);

        Assertions
                .assertThat(studentDTO.getAverageScore())
                .isEqualTo(6d);
    }

    private void postStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pepe Juarez");
        var studentAsJson = writer.writeValueAsString(studentDTO);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentAsJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
