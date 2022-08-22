package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static com.meli.obtenerdiploma.util.TestUtilsGenerator.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentDAO studentDAO;

    private ObjectWriter writer;

    @BeforeEach
    public void setUp() {
        emptyUsersFile();
        this.writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        StudentDTO stu = getStudentWithId(1L);
        if (!studentDAO.exists(stu)) {
            studentDAO.save(stu);
        }
    }


    @Test
    public void analizeScoreTest() throws Exception {

        StudentDTO studentExpect = getStudentWithId(1L);
        Double average = studentExpect.getSubjects().stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / studentExpect.getSubjects().size();

        String message = "El alumno "+ studentExpect.getStudentName() +" ha obtenido un promedio de " + new DecimalFormat("#0.00").format(average) +". Puedes mejorar.";

        studentExpect.setAverageScore(average);
        studentExpect.setMessage(message);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String expectJson = writer.writeValueAsString(studentExpect);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectJson,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


}
