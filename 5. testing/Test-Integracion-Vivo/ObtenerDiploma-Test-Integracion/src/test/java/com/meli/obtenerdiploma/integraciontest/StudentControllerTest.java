package com.meli.obtenerdiploma.integraciontest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void listStudentsTest() throws Exception {

        this.mockMvc.perform(get("/student/listStudents"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }


    @Test
    public void registerStudentNameNotValidTest() throws Exception {

        List<SubjectDTO> listSubject = new ArrayList<>();

        listSubject.add(new SubjectDTO("Español", 4.0));
        listSubject.add(new SubjectDTO("Etica", 7.0));

        String message = "El alumno  ha obtenido un promedio de 7.33. Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(1L, "", message, 7.333333333333333, listSubject);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentDTOJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentDTOJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));;


    }


    @Test
    public void removeStudentWithIdTest() throws Exception {


        this.mockMvc.perform(get("/student/removeStudent/{id}", 67))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());

    }

    @Test
    public void getStudentUnknownTest() throws Exception{

        this.mockMvc.perform(get("/student/getStudent/{id}", 35))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }


    @Test
    public void modifyStudentScoreOutRangeTest() throws Exception {

        List<SubjectDTO> listSubject = new ArrayList<>();

        listSubject.add(new SubjectDTO("Español", 54.0));
        listSubject.add(new SubjectDTO("Etica", 7.0));

        String message = "El alumno Manuel ha obtenido un promedio de 7.33. Puedes mejorar.";
        StudentDTO studentDTO = new StudentDTO(8L, "Manuel", message, 7.333333333333333, listSubject);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String studentDTOJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(studentDTOJson))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));;


    }




}
