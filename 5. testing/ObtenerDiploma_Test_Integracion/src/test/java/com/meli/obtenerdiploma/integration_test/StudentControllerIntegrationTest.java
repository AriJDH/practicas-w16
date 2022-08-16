package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    private static String BASE_URL="/student/";

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registerStudent() throws Exception{

        StudentDTO studentDTO = new StudentDTO(3L, "Jobs", "No message", null,
                List.of(new SubjectDTO("Math", 4.5)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    public void registerStudentButValidNameNotBlank() throws Exception{

        StudentDTO studentDTO = new StudentDTO(3L, "", "No message", null,
                List.of(new SubjectDTO("Math", 4.5)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));
    }



    @Test
    public void getStudentByIdController() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL+"getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.studentName").value("Jobs"));


    }
    
    @Test
    public void getStudentByIdButItsNotFound() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL+"getStudent/{id}", 4932))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException))
                .andExpect(jsonPath("$.description").value("El alumno con Id 4932 no se encuetra registrado."));

    }

    @Test
    void modifyExistingStudent() throws Exception {
        StudentDTO studentDTO = new StudentDTO(3L, "Jobs", "Updating a new student", 4.5,
                List.of(new SubjectDTO("Math", 4.5)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void modifyExistingStudentButNameToLoweCase() throws Exception {
        StudentDTO studentDTO = new StudentDTO(45987L, "jobs", "Updating a new student", 4.5,
                List.of(new SubjectDTO("Math", 4.5)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post(BASE_URL+"modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException));

    }

    @Test
    void deletingAStudent() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL+"removeStudent/{id}", 3))
                .andDo(print())
                .andExpect(status().isOk());

    }


}
