package com.meli.obtenerdiploma.integrationTest;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

import org.apache.velocity.app.event.ReferenceInsertionEventHandler.referenceInsertExecutor;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.MultiValueMap;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {

   @Autowired
   private MockMvc mockMvc;

   static ObjectWriter writer;
   private StudentDAO studentDAO;
   private StudentDTO aleStudent;
   private List<SubjectDTO> aleSubjects;
   private StudentDTO referenceStudent;

   @BeforeAll
   public static void preConfig() {
      writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
   }

   @BeforeEach
   public void setUp() {
      studentDAO = new StudentDAO();

      aleSubjects = List.of(new SubjectDTO("Matematica", 8.0), new SubjectDTO("Leangua", 7.0));

      aleStudent = new StudentDTO(null, "Alejandro", null, null, aleSubjects);
      referenceStudent = new StudentDTO(1L, "Alejandro", null, null, aleSubjects);
      if (!studentDAO.exists(referenceStudent))
         studentDAO.save(aleStudent);

   }

   @Test
   void shouldAnalizeScores() throws Exception {
      this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores")
         .param("studentId","1"))  
      .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
         .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
         .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Alejandro ha obtenido un promedio de 7.5. Puedes mejorar."));   
   }

}
