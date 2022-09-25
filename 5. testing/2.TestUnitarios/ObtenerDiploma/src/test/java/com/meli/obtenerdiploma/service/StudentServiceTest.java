package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentServiceTest {

    @Test
    void create() {

        String expectedResult = "";

        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);

        String result = student.getStudentName();
        expectedResult = "Yenny";

        assertEquals(expectedResult,result);

    }

    @Test
    void createVaciosNulos() {

        String expectedResult = "";

        SubjectDTO subject = new SubjectDTO("Materia2",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"","estudiante 1",7.0,subjectList);

        String result = student.getStudentName();

        assertEquals(expectedResult,result);

    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAll() {
    }
}