package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.DecimalFormat;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        TestUtilsGenerator.emptyUsersFile();

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void beforEach() {
        SubjectDTO kahoot = new SubjectDTO("Kahoot", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO poo =    new SubjectDTO("POO",    2.0);

        StudentDTO student =new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

        if( ! studentDAO.exists( student ) )
            studentDAO.save( student );

    }

    @Test
    public void testAnalyzeScores() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.averageScore").value(4.0))
                .andExpect(jsonPath("$.message").value("El alumno Anibal ha obtenido un promedio de 4.00. Puedes mejorar."));
    }

    @Test
    public void testAnalyzeScoresNonExistingStudent() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 22L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 22 no se encuetra registrado."))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }
}
