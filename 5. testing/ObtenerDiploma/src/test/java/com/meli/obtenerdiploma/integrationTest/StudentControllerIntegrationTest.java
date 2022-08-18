package com.meli.obtenerdiploma.integrationTest;

import org.apache.tomcat.util.http.parser.MediaType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private StudentRepository studentRepository;

   static ObjectWriter writer;
   private StudentDAO studentDAO;
   private StudentDTO aleStudent;
   private StudentDTO referenceStudent;
   private List<SubjectDTO> aleSubjects;

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
   void shouldRetriveAStudent() throws Exception {

      this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Alejandro"));

   }

   @Test
   void shouldRemoveAStudent() throws Exception {
      this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
   }

   @Test
   void shouldRetriveFullStudentList() throws Exception {

      String responseJson = writer.writeValueAsString(studentRepository.findAll());

      MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andReturn();

      Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());
   }

   @Test
   void shouldRegisterAStudent() throws Exception {

      String payloadJson = writer.writeValueAsString(aleStudent);

      this.mockMvc
            .perform(MockMvcRequestBuilders.post("/student/registerStudent").contentType("application/json")
                  .content(payloadJson))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

   }

   @Test
   void shouldModifyAStudent() throws Exception {

      String payloadJson = writer.writeValueAsString(referenceStudent);
      this.mockMvc
            .perform(MockMvcRequestBuilders.post("/student/modifyStudent").contentType("application/json")
                  .content(payloadJson))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());

   }

   @Test
   void shouldAnalyzeScores() throws Exception {
      this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores").param("studentId", "1"))
            .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andExpect(MockMvcResultMatchers
                  .jsonPath("$.message").value("El alumno Alejandro ha obtenido un promedio de 7.5. Puedes mejorar."));
   }

}
