package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    public void reset() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    public void registerStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Gonzalo");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadStudentDTOJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadStudentDTOJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void registerStudentWithInvalidNameTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("gonzalo");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadStudentDTOJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadStudentDTOJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void registerStudentWithInvalidJsonTest() throws Exception {
        String payloadStudentDTOJson = "Gonzalo";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadStudentDTOJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void getStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Gonzalo");
        this.studentService.create(studentDTO);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseStudentDTOJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseStudentDTOJson));
    }

    @Test
    public void getInvalidStudentTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void modifyStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Gonzalo");
        this.studentService.create(studentDTO);

        studentDTO.setStudentName("Pablo");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadStudentDTOJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadStudentDTOJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void modifyStudentWithInvalidSubjectListTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Gonzalo");
        this.studentService.create(studentDTO);

        studentDTO.setSubjects(new ArrayList());
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadStudentDTOJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadStudentDTOJson))
                .andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void removeStudentTest() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Gonzalo");
        this.studentService.create(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void listStudentsTest() throws Exception {
        StudentDTO gonzalo = TestUtilsGenerator.getStudentWith3Subjects("Gonzalo");
        StudentDTO pablo = TestUtilsGenerator.getStudentWith3Subjects("Pablo");
        StudentDTO juan = TestUtilsGenerator.getStudentWith3Subjects("Juan");
        this.studentService.create(gonzalo);
        this.studentService.create(pablo);
        this.studentService.create(juan);
        Set<StudentDTO> studentDTOSet = new HashSet(Set.of(gonzalo, pablo, juan));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String responseStudentDTOSet = writer.writeValueAsString(studentDTOSet);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(responseStudentDTOSet));
    }

}
