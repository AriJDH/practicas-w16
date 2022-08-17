package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    private static final StudentDAO studentDAO = new StudentDAO();

    private static StudentDTO s1;
    private static StudentDTO s2;

    private static ObjectMapper mapper;

    @BeforeAll
    public static void setUp() {
        s1 = TestUtils.generateNormalStudent("Student 1", 99L);
        s2 = TestUtils.generateHonoredStudent("Student 2", 99L);
        studentDAO.save(s1);
        studentDAO.save(s2);

        mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    }

    @AfterAll
    public static void clear() {
        TestUtils.emptyFile();
    }

    @Test
    public void testAnalyzeScoresValidNormalStudent() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(s1.getId()))
                .andExpect(jsonPath("$.studentName").value(s1.getStudentName()))
                .andExpect(jsonPath("$.subjects.length()").value(2))
                .andReturn();

        StudentDTO response = mapper.readValue(result.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertTrue(response.getMessage().endsWith("Puedes mejorar."));
        Assertions.assertTrue(response.getAverageScore() <= 9);
    }

    @Test
    public void testAnalyzeScoresValidHonoredStudent() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(s2.getId()))
                .andExpect(jsonPath("$.studentName").value(s2.getStudentName()))
                .andExpect(jsonPath("$.subjects.length()").value(2))
                .andReturn();

        StudentDTO response = mapper.readValue(result.getResponse().getContentAsString(), StudentDTO.class);
        Assertions.assertTrue(response.getMessage().endsWith("Felicitaciones!"));
        Assertions.assertTrue(response.getAverageScore() > 9);
    }

    @Test
    public void testAnalyzeScoresNonexistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 3))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }
}
