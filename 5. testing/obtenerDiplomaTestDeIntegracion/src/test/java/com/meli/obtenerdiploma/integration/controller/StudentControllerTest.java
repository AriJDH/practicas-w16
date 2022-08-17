package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.integration.dto.StudentDtoTest;
import com.meli.obtenerdiploma.integration.dto.SubjectDtoTest;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(5)
    void listStudentsTest() throws Exception {
        this.mockMvc.perform(get("/student/listStudents").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect( jsonPath("$").isArray()   )
                .andExpect(jsonPath("$.[0].studentName").exists() );
    }

    @Test
    @Order(2)
    void registerStudentWithEmptySubjectsListExceptionTest() throws Exception {
        StudentDtoTest payloadDTO = new StudentDtoTest(4L, "Jose", null, null,
                List.of());

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description")
                        .value("La lista de materias no puede estar vacía."));
    }

    @Test
    @Order(6)
    void getStudentTest() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("George"))
                .andExpect(jsonPath("$.subjects[0].name").value("Geografia"))
                .andExpect(jsonPath("$.subjects[0].score").value("8.0"));
    }

    @Test
    @Order(7)
    void getStudentNotFoundTest() throws Exception {
        this.mockMvc.perform(get("/student/getStudent/{id}", -1))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description")
                        .value("El alumno con Id -1 no se encuetra registrado."));
    }

    @Test
    @Order(1)
    void registerStudentTest() throws Exception {

        SubjectDtoTest geographic = new SubjectDtoTest("Geografia", 8D);
        SubjectDtoTest literature = new SubjectDtoTest("Literatura", 8D);
        SubjectDtoTest science = new SubjectDtoTest("Ciencias Naturales", 8D);
        StudentDtoTest payloadDTO = new StudentDtoTest(3L, "George", null, null,
                List.of(geographic, literature, science));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(3)
    void modifyStudentTest() throws Exception {
        SubjectDtoTest geographic = new SubjectDtoTest("Geografia", 7D);
        SubjectDtoTest science = new SubjectDtoTest("Ciencias Naturales", 9D);
        StudentDtoTest payloadDTO = new StudentDtoTest(3L, "Milu", null, null,
                List.of(geographic, science));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    void modifyStudentWithoutStudentNameExceptionTest() throws Exception {
        SubjectDtoTest psicologia = new SubjectDtoTest("Psicologia", 7D);
        SubjectDtoTest filosofia = new SubjectDtoTest("Filosofia", 9D);
        StudentDtoTest payloadDTO = new StudentDtoTest(1L, null, null, null,
                List.of(psicologia, filosofia));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(payloadDTO);

        this.mockMvc.perform(post("/student/modifyStudent").contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(jsonPath("$.description")
                        .value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    @Order(8)
    void removeStudentTest() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{id}", 3L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @Order(9)
    void removeStudentIdNotValidExceptionTest() throws Exception {
        this.mockMvc.perform(get("/student/removeStudent/{id}", "A").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentTypeMismatchException));
    }

    @Test
    @Order(10)
    void registerStudentHttpMessageNotReadableExceptionTest() throws Exception {
        String payloadJson = "a";
        this.mockMvc.perform(post("/student/registerStudent").contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }
}
