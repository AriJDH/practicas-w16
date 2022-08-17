package com.meli.obtenerdiploma.integration_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    public void beforEach() {
        TestUtilsGenerator.emptyUsersFile();

        SubjectDTO kahoot = new SubjectDTO("Kahoot", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO poo =    new SubjectDTO("POO",    2.0);

        StudentDTO student =new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

        if( ! studentDAO.exists( student ) )
            studentDAO.save( student );

    }

    @Test
    public void registerStudentTest() throws Exception{

        StudentDTO studentDTO = new StudentDTO(2L, "Student2", "No message", null,
                List.of(new SubjectDTO("Math", 4.5)));

        String payloadJson = writer.writeValueAsString(studentDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void getStudentTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}","1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Anibal"));

    }

    @Test
    public void getStudentWhoDoesntExistTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}","-1"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id -1 no se encuetra registrado."));

    }

    @Test
    public void modifyStudentTest() throws Exception{

        SubjectDTO kahoot = new SubjectDTO("Kahoot", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO poo =    new SubjectDTO("POO",    2.0);

        StudentDTO student =new StudentDTO(1L, "Fernando","El alumno Anibal ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void modifyStudentWhoDoesntExistTest() throws Exception{

        SubjectDTO kahoot = new SubjectDTO("Kahoot", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO poo =    new SubjectDTO("POO",    2.0);

        StudentDTO student =new StudentDTO(14L, "Fernando","El alumno Fernando ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

        String payloadJson = writer.writeValueAsString(student);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudentTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}","1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void removeStudentDoesntExistTest() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}","20"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    }


}
