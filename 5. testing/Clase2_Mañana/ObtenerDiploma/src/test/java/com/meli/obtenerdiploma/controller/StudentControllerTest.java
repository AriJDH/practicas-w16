package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    private String payloadJson;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    IStudentService studentService;

    @BeforeEach
    void createUserJson() throws JsonProcessingException {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("Math", 9.0);
        SubjectDTO english = new SubjectDTO("English", 7.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 6.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(12L, "Carlos", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        payloadJson = (writer).writeValueAsString(payloadDTO);
    }

    @Test
    void registerStudentTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void registerStudentExceptionTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("payloadJson"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    void registerStudentWrongNameTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("Math", 9.0);
        SubjectDTO english = new SubjectDTO("English", 7.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 6.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(12L, "carlos", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String wrongPayload = writer.writeValueAsString(payloadDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wrongPayload))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void registerStudentNoNameTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("Math", 9.0);
        SubjectDTO english = new SubjectDTO("English", 7.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 6.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(12L, "", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String wrongPayload = writer.writeValueAsString(payloadDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wrongPayload))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void registerStudentNoListTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        StudentDTO payloadDTO = new StudentDTO(12L, "Carlos", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String wrongPayload = writer.writeValueAsString(payloadDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wrongPayload))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void registerStudentWrongSubjectNameTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("math", 9.0);
        SubjectDTO english = new SubjectDTO("English", 7.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 6.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(12L, "Carlos", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String wrongPayload = writer.writeValueAsString(payloadDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wrongPayload))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void registerStudentBelowZeroScoreTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("Math", -3.0);
        SubjectDTO english = new SubjectDTO("English", 7.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 6.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(12L, "Carlos", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String wrongPayload = writer.writeValueAsString(payloadDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wrongPayload))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void registerStudentMoreThanTenScoreTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("Math", 13.0);
        SubjectDTO english = new SubjectDTO("English", 7.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 6.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(12L, "Carlos", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String wrongPayload = writer.writeValueAsString(payloadDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(wrongPayload))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    void getStudentTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Carlos"));
    }

    @Test
    void getStudentNotFoundTest() throws Exception {
        long variable = 40L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", variable))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id "+ variable + " no se encuetra registrado."));
    }

    @Test
    void getStudentWrongParameterTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", "variable"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentTypeMismatchException));
    }

    @Test
    void modifyStudentTest() throws Exception {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO maths = new SubjectDTO("Math", 9.0);
        SubjectDTO english = new SubjectDTO("English", 7.0);
        SubjectDTO philosophy = new SubjectDTO("Philosophy", 6.0);
        subjects.add(maths);
        subjects.add(english);
        subjects.add(philosophy);
        StudentDTO payloadDTO = new StudentDTO(1L, "CarlosModified", null, null, subjects);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String modified = writer.writeValueAsString(payloadDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(modified))
                .andDo(print()).andExpect(status().isOk());
    }


    @Test
    void removeStudentTest() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void listStudentsTest() throws Exception {
        Set<StudentDTO> list = studentService.getAll();
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(list.size()));
    }
}