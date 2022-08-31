package com.diploma.diploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.diploma.diploma.controller.StudentController;
import com.diploma.diploma.exceptions.StudentNotFoundException;
import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.service.IStudentService;
import com.diploma.util.UtilTestTools;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {
    
    private String payloadJson;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void createUserJson() throws Exception {
        StudentDTO payloadDTO =  UtilTestTools.generateStudentWithIdAndAverage("Francisco", 9.10, 2L);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper
                            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                            .writer();

        payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson));
    }

    @Test
    public void testObtenerDiplomaControllerAnalyzeScores() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}", 2))
                                    .andDo(print()).andExpect(status().isOk())
                                    .andExpect(content().contentType("application/json"))
                                    .andExpect(jsonPath("$.message").value("El alumno Francisco ha obtenido un promedio de 9.10. Felicitaciones!"))
                                    .andReturn();

        assertEquals("application/json",mvcResult.getResponse().getContentType());

    }

    @Test
    void analyzeEmptyScoresTest() throws Exception {
        Long variable = 40L;
        this.mockMvc.perform(get("/analyzeScores/{studentId}", variable)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException))
                .andExpect(jsonPath("$.description").value("El alumno con Id "+ variable + " no se encuetra registrado."));
    }
}
