package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup(){
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.setUpIntegrationTests();
    }

    @Test
    void addStudentTest() throws Exception {
        StudentDTO studentRequest = TestUtilsGenerator.getStudentWith3Subjects("Guillermo");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String requestJson = writer.writeValueAsString(studentRequest);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void addInvalidSubjectStundentTest() throws Exception {
        StudentDTO studentRequest = TestUtilsGenerator.getStudentWith3Subjects("Guillermo");
        studentRequest.setSubjects(new ArrayList<>());

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String requestJson = writer.writeValueAsString(studentRequest);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result-> Assertions.assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andExpect(jsonPath("$.description").value("La lista de materias no puede estar vacía."));

    }

    @Test
    void registerInvalidStudentNameTest() throws Exception {
        StudentDTO student = TestUtilsGenerator.getStudentWith3Subjects("");
        ObjectWriter objectWriter = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payload = objectWriter.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(result-> Assertions.assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }

    @Test
    void getNotExistentStudentByIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getStudent/{studentId}", 999))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getStudentByInvalidIdTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getStudent/{studentId}", "Letters"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void getStudentByIdTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void removeValidStudentTest() throws Exception {
        int searchid = 1;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", searchid))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    void removeInvalidStudentTest() throws Exception {
        int searchid = 878787;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", searchid))
                .andDo(print())
                .andExpect(status().isNotFound());

    }
    @Test
    void getListOfAllValidStudentsTest() throws Exception {
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
}
