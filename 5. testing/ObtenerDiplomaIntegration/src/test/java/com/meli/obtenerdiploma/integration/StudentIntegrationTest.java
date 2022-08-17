package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class StudentIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private StudentDAO studentDAO;
    private static StudentDTO s1;
    private static StudentDTO s2;

    private static final ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false);

    @BeforeEach
    public void setUp() {
        s1 = TestUtils.generateNormalStudent("Student 1", 99L);
        s2 = TestUtils.generateHonoredStudent("Student 2", 99L);
        studentDAO.reloadData();
        studentDAO.save(s1);
        studentDAO.save(s2);
    }

    @AfterEach
    public void clear() {
        TestUtils.emptyFile();
    }

    @Test
    public void testRegisterValidStudent() throws Exception {
        StudentDTO newStudent = TestUtils.generateStudent2Subjects("New student", 99L);

        String payload = mapper.writeValueAsString(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testRegisterInvalidStudent() throws Exception {
        StudentDTO newStudent = TestUtils.generateStudent2Subjects("lowercase", 99L);

        String payload = mapper.writer().withDefaultPrettyPrinter()
                .writeValueAsString(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void testRegisterNoBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    public void testGetExistingStudent() throws Exception {
        String jsonResponse = mapper.writeValueAsString(s1);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", s1.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonResponse));
    }

    @Test
    public void testGetNonexistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 99))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    public void testModifyValidStudent() throws Exception {
        StudentDTO newStudent = TestUtils.generateStudent2Subjects("New student", 1L);

        String payload = mapper.writeValueAsString(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void testModifyInvalidStudent() throws Exception {
        StudentDTO newStudent = TestUtils.generateStudent2Subjects("lowercase", 1L);

        String payload = mapper.writer().withDefaultPrettyPrinter()
                .writeValueAsString(newStudent);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void testModifyNoBody() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("HttpMessageNotReadableException"));
    }

    @Test
    public void testRemoveExistingStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", s2.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));

    }

    @Test
    public void testRemoveNonexistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 99L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));

    }

    @Test
    public void testListStudents() throws Exception {
        Set<StudentDTO> students = new HashSet<>(){{
            add(s1);
            add(s2);
        }};

        String expectedSet = mapper.writeValueAsString(students);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(expectedSet));
    }
}
