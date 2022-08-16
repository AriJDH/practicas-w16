package com.meli.obtenerdiploma.integraciontest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    public void beforEach() {
        List<SubjectDTO> listSubject = new ArrayList<>();

        listSubject.add(new SubjectDTO("Matemática", 9.0));
        listSubject.add(new SubjectDTO("Física", 7.0));
        listSubject.add(new SubjectDTO("Química", 6.0));

        String message = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", message, 7.333333333333333, listSubject);

        StudentDAO studentDAO = new StudentDAO();

        if( ! studentDAO.exists( studentDTO ) ) {

            studentDAO.save( studentDTO );

        }


    }


    @Test
    public void analyzeScoresTest() throws Exception{

        List<SubjectDTO> listSubject = new ArrayList<>();

        listSubject.add(new SubjectDTO("Matemática", 9.0));
        listSubject.add(new SubjectDTO("Física", 7.0));
        listSubject.add(new SubjectDTO("Química", 6.0));

        String message = "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "Juan", message, 7.333333333333333, listSubject);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentDTOJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = this.mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(studentDTOJson, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }


    @Test
    void StudentNotFoundExceptionTest() throws Exception {

        this.mockMvc.perform(get("/analyzeScores/{studentId}", 97))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}
