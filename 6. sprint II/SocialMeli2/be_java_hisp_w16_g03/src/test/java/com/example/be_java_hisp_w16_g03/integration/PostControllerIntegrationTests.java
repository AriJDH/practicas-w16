package com.example.be_java_hisp_w16_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Test
    public void analizeScoreTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matemática", 9.0));
        subjects.add(new SubjectDTO("Física", 7.0));
        subjects.add(new SubjectDTO("Química", 6.0));
        Double average = subjects.stream()
                .reduce(0D, (partialSum, score)  -> partialSum + score.getScore(), Double::sum)
                / subjects.size();

        String message = "El alumno Juan ha obtenido un promedio de " + new DecimalFormat("#0.00").format(average) +". Puedes mejorar.";
        StudentDTO studentExpect = new StudentDTO(1L, "Juan", message, average, subjects);

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
