package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
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

import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.meli.obtenerdiploma.util.TestUtilsGenerator.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentDAO studentDAO;
    private ObjectWriter writer;


    @BeforeEach
    public void setUp() {
        emptyUsersFile();
        this.writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();

        StudentDTO stu = getStudentWithId(1L);
        if (!studentDAO.exists(stu)) {
            studentDAO.save(stu);
        }
    }

    @Test
    public void registerStudentTest() throws Exception {
        StudentDTO stu = getStudentWith3Subjects("Maria");

        String body = this.writer.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(body))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getStudentByIdTest() throws Exception {

        StudentDTO stu = getStudentWithId(1L);

        String expected = this.writer.writeValueAsString(stu);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expected, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void removeStudentTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void shouldRetriveFullStudentList() throws Exception {

        String responseJson = this.writer.writeValueAsString(studentRepository.findAll());

        MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json")).andReturn();

        Assertions.assertEquals(responseJson, response.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void shouldModifyAStudent() throws Exception {
        StudentDTO stu =  getStudentWithId(1L);
        String payloadJson = writer.writeValueAsString(stu);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/student/modifyStudent").contentType("application/json")
                        .content(payloadJson))
                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveStudentValidation() throws Exception {
        StudentDTO stu = getStudentWith3Subjects("maria");

        String body = this.writer.writeValueAsString(stu);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(body))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

    @Test
    void studentNotFound() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 56L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    public void registerStudentException() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType("application/json")
                        .content(String.valueOf(1)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }




}
