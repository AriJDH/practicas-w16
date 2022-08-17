package com.meli.obtenerdiploma.controller.Integration;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    static StudentDAO studentDao = new StudentDAO();

    @BeforeEach
    public void beforEach() {
        SubjectDTO matem = new SubjectDTO("Matematica",9.0);
        SubjectDTO fis = new SubjectDTO("Fisica",7.0);
        SubjectDTO quim = new SubjectDTO("Quimica",6.0);

        StudentDTO juan =
                new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                        7.333333333333333, Arrays.asList(matem,fis,quim));

        if( ! studentDao.exists( juan ) )
            studentDao.save( juan );
    }

    @Test
    public void testAnalyzeScoresOutput() throws Exception{
        //Arrange
        SubjectDTO matem = new SubjectDTO("Matematica",9.0);
        SubjectDTO fis = new SubjectDTO("Fisica",7.0);
        SubjectDTO quim = new SubjectDTO("Quimica",6.0);

        StudentDTO juan =
                new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                        7.333333333333333, Arrays.asList(matem,fis,quim));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
        //Act
        MvcResult mvcResult =
                mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","1"))
                        .andDo(print()).andExpect(status().isOk())
                        .andExpect(content().contentType("application/json"))
                        .andReturn();
        //Assert
        Assertions.assertEquals(writer.writeValueAsString(juan),mvcResult.getResponse().getContentAsString());

    }

    @Test
    public void TestExceptionAnallyzeStudent() throws Exception{

                mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}","99"))
                        .andDo(MockMvcResultHandlers.print())
                        .andExpect(status().isNotFound())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }
}
