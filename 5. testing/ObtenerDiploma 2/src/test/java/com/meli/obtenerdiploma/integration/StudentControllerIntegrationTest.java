package com.meli.obtenerdiploma.integration;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterStudent() throws Exception {

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> listaMaterias = new ArrayList<>();
        SubjectDTO subject1 = new SubjectDTO("Mathematics",5.7);
        SubjectDTO subject2 = new SubjectDTO("Química",9.9);
        listaMaterias.add(subject1);
        listaMaterias.add(subject2);
        studentDTO.setStudentName("Juan");
        studentDTO.setSubjects(listaMaterias);
        studentDTO.setId(1L);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRegisterStudentNotValid() throws Exception {

        StudentDTO studentDTO = new StudentDTO();

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testGetStudent() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 6L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(6L))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
        ;
    }

    @Test
    public void testGetStudentExceptionIdNotFound() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 777L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"));
    }

    @Test
    public void testModifyStudent() throws Exception {

        StudentDTO studentDTO = new StudentDTO();
        List<SubjectDTO> listaMaterias = new ArrayList<>();

        SubjectDTO subject1 = new SubjectDTO("Mathematics",5.7);
        SubjectDTO subject2 = new SubjectDTO("Química",9.9);
        listaMaterias.add(subject1);
        listaMaterias.add(subject2);

        studentDTO.setStudentName("Marcos");
        studentDTO.setSubjects(listaMaterias);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer().withDefaultPrettyPrinter();

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testRemoveStudent() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testListStudents() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));
    }
}
