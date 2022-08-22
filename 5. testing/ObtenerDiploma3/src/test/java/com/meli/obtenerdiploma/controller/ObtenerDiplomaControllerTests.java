package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    public void testAnalyzeScoresWithAnExistingStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWithId(90L);

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    public void testAnalyzeScoresWithAnExistingStudentId() throws Exception {
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                        .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    public void testAnalyzeScoresWithAnNonExistingStudentId() throws Exception {
        MvcResult mvcResult =
                this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 9000)
                                .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isNotFound())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 9000 no se encuetra registrado."))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                        .andReturn();

        Assertions.assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

}
