package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentIT {

    @Autowired
    private MockMvc mockMvc;

    private ObjectWriter writer;

    @BeforeEach
    void initialize() {
        writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
    }

    @AfterEach
    void tearDown() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test // @RequestBody @Valid StudentDTO
    void postNewStudent() throws Exception { //"/registerStudent"
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pepe Juarez");
        var studentAsJson = writer.writeValueAsString(studentDTO);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentAsJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test // @PathVariable Long id ºº "/getStudent/{id}"
    void getStudentById() throws Exception {
        postStudent();

        var response = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", 1l))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        StudentDTO obtainedStudent = new ObjectMapper().readValue(response.getResponse().getContentAsString(), StudentDTO.class);

        assertFalse(obtainedStudent == null);
        assertEquals(obtainedStudent.getId(), 1l);
    }


    @Test
    void getStudentByNoExistentIdRaiseException() throws Exception {
        var noExistentStudentId = 999999l;
        ErrorDTO errorDTO = new ErrorDTO(
                "StudentNotFoundException",
                "El alumno con Id " + noExistentStudentId + " no se encuetra registrado.");

        var errorDTOAsJson = writer.writeValueAsString(errorDTO);

        var response = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", noExistentStudentId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();

        assertEquals(response.getResponse().getContentAsString(), errorDTOAsJson);
    }

    @Test // @PostMapping("/modifyStudent") ºº @RequestBody @Valid StudentDTO stu
    void postUpdateAnStudent() throws Exception {
        long saveStudentId = 1l;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pedro Reloaded");
        studentDTO.setId(saveStudentId);

        postStudent();

        var studentAsJson = writer.writeValueAsString(studentDTO);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentAsJson))
                .andDo(print())
                .andExpect(status().isOk());

        var response = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", saveStudentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        StudentDTO updatedStudent =
                new ObjectMapper()
                        .readValue(response.getResponse().getContentAsString(), StudentDTO.class);

        assertEquals(updatedStudent.getStudentName(), studentDTO.getStudentName());
    }

    @Test
    void getRemoveStudentById() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{studentId}", 1l))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void getRemoveStudentByNoExistentIdRaiseException() throws Exception {
        var noExistentStudentId = 999999l;

        mockMvc
                .perform(MockMvcRequestBuilders.get("/student/removeStudent/{studentId}", noExistentStudentId))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test // @GetMapping("/listStudents")
    void getAllStudents() throws Exception {
        postStudent();

        var response = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/getStudent/{studentId}", 1l))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        StudentDTO obtainedStudent = new ObjectMapper().readValue(response.getResponse().getContentAsString(), StudentDTO.class);

        var allStudentsResponse = mockMvc
                .perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        List<StudentDTO> allStudentsParsed = new ObjectMapper().readValue(allStudentsResponse.getResponse().getContentAsString(), new TypeReference<List<StudentDTO>>(){});

        assertTrue(allStudentsParsed.contains(obtainedStudent));
    }

    private void postStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pepe Juarez");
        var studentAsJson = writer.writeValueAsString(studentDTO);

        mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentAsJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
