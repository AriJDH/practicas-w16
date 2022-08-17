package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTestObtenerDiploma {

    @Autowired
    private MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    StudentDTO estudiante;
    SubjectDTO matematica;
    SubjectDTO fisica;
    SubjectDTO quimica;



    @BeforeEach
    public void setearEstudiante(){
        matematica = new SubjectDTO("Matemática", 9.0);
        fisica = new SubjectDTO("Física", 7.0);
        quimica = new SubjectDTO("Química", 6.0);

        estudiante = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de 7,33. Puedes mejorar.", 7.333333333333333, List.of(matematica,fisica,quimica));

        if (!studentDAO.exists(estudiante))
            studentDAO.save(estudiante);
    }

    @Test
    public void testValidAverageScore() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}",1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.averageScore").value(7.333333333333333))
                .andExpect(jsonPath("$.subjects.length()").value(3))
                //.andExpect(jsonPath("$.message").value(""))
                .andExpect(jsonPath("$.subjects[0].name").value("Matemática"))
                .andExpect(jsonPath("$.subjects[1].name").value("Física"))
                .andExpect(jsonPath("$.subjects[2].name").value("Química"))
        ;
    }


}
