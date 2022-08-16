package com.meli.obtenerdiploma.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetStudentIsOk() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andReturn();
    }

    @Test
    public void testGetStudentNotOk() throws  Exception{
        ErrorDTO error = new ErrorDTO("StudentNotFoundException", "El alumno con Id " + -1 + " no se encuetra registrado.");

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",-1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(writer.writeValueAsString(error), mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testRegisterStudentOk() throws Exception{
        List<SubjectDTO> subjectsDTO = new ArrayList<>(List.of(new SubjectDTO("Fisica",8D)));
        StudentDTO studentDTO = new StudentDTO(3L,"Juan","Hola",null,subjectsDTO);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").
                        contentType("application/json").
                        content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testRegisterInvalidStudent() throws Exception{
        List<SubjectDTO> subjectsDTO = new ArrayList<>(List.of(new SubjectDTO("Fisica",8D)));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSubjects(subjectsDTO);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").
                        contentType("application/json").
                        content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andReturn();
    }

    @Test
    public void testRegisterNullStudent() throws Exception{
        StudentDTO studentDTO = null;

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent").
                        contentType("application/json").
                        content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void testModifyStudentOk() throws Exception {
        List<SubjectDTO> subjectsDTO = new ArrayList<>(List.of(new SubjectDTO("Fisica", 8D)));
        StudentDTO studentDTO = new StudentDTO(1L,"Juan","Mensaje",null,subjectsDTO);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").
                        contentType("application/json").
                        content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testModifyInvalidStudent() throws Exception {
        List<SubjectDTO> subjectsDTO = new ArrayList<>(List.of(new SubjectDTO("Fisica", 8D)));
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setSubjects(subjectsDTO);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").
                        contentType("application/json").
                        content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    public void testModifyNullStudent() throws Exception {
        StudentDTO studentDTO = null;

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer().withDefaultPrettyPrinter();

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent").
                        contentType("application/json").
                        content(writer.writeValueAsString(studentDTO)))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }


    @Test
    public void testRemoveStudentIsOk() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",3))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testRemoveInvalidStudent() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",-1))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void testListStudentsIsOk() throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(3)))
                .andReturn();
    }

    }
