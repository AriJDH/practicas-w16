package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

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
    void testRegisterStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Jessica");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentDtoJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDtoJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testRegisterStudentInvalidName() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("jessica");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentDtoJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDtoJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    @Test
    void testGetStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Jessica");
        studentService.create(studentDTO);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String studentDtoJson = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andExpect(content().contentType("application/json"))
                .andExpect(content().json(studentDtoJson))
                .andDo((MockMvcResultHandlers.print()))
                .andExpect(status().isOk());
    }

    @Test
    void testGetStudentNotFound() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testModifyStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Jessica");
        studentService.create(studentDTO);

        studentDTO.setStudentName("Jessica Alexandra");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String studentDtoJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDtoJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void removeStudent() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Jessica");
        studentService.create(studentDTO);


        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudents() throws Exception {
        StudentDTO studentDTO1 = TestUtilsGenerator.getStudentWith3Subjects("Jessica");
        StudentDTO studentDTO2 = TestUtilsGenerator.getStudentWith3Subjects("Erika");

        studentService.create(studentDTO1);
        studentService.create(studentDTO2);

        Set<StudentDTO> studentDTOSet = new HashSet(Set.of(studentDTO1,studentDTO2));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String studentDtoSetJson = writer.writeValueAsString(studentDTOSet);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(content().json(studentDtoSetJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterStudentWithInvalidJson() throws Exception {
        String studentDTOJson = "Jessica";

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDTOJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}