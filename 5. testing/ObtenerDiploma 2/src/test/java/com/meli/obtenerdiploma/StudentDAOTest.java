package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {
    @Autowired
    IStudentDAO studentDAO;

    private StudentDTO studentDTO;

    @BeforeEach
    void setUp() {
        studentDTO = new StudentDTO();
    }

    @Test
    public void addStudentDaoNull() {
        studentDAO.save(studentDTO);
    }

    @Test
    public void addStudentOk() {
        List<SubjectDTO> subjectDTOList = Arrays.asList(new SubjectDTO("Fisica", 9.5));
        studentDTO.setId(1L);
        studentDTO.setStudentName("Juan");
        studentDTO.setMessage("Hola");
        studentDTO.setAverageScore(1.7);
        studentDTO.setSubjects(subjectDTOList);
        studentDAO.save(studentDTO);
        assertTrue(studentDAO.exists(studentDTO));
    }

    @Test
    public void getNameStudentOk() {
        studentDTO.setStudentName("Juan");
        String resultExpected = "Juan";
        String result = studentDTO.getStudentName();
        assertEquals(resultExpected, result);
    }

    @Test
    public void getStudentMessageOk(){
        studentDTO.setMessage("Hola");
        String resultExpected = "Hola";
        String result = studentDTO.getMessage();
        assertEquals(resultExpected,result);
    }




}
