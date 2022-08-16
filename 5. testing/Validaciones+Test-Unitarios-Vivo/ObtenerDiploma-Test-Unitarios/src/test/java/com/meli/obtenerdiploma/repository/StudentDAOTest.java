package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentDAOTest {

    @Test
    public void saveTest(){

        //Arrange
        //Input
        Long idStudent = 1L;

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matemáticas");
        subjectDTO.setScore(8.5);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(subjectDTO);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Tomas");
        studentDTO.setAverageScore(8.2);
        studentDTO.setSubjects(listSubject);

        //output
        StudentDTO responseStudenDTO;
        StudentDAO studentDAO = new StudentDAO();

        //Act
        studentDAO.save(studentDTO);
        responseStudenDTO = studentDAO.findById(idStudent);

        //Assert
        assertEquals(studentDTO, responseStudenDTO);

    }


    @Test
    public void findById(){

        //Arrange
        Long idStudent = 1L;

        //Act
        StudentDAO studentDAO = new StudentDAO();
        Long responseId = studentDAO.findById(idStudent).getId();

        //Assert
        assertEquals(idStudent, responseId);

    }


    @Test
    public void modifyTest(){

        //Arrange
        //Input
        Long idStudent = 1L;

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Matemáticas");
        subjectDTO.setScore(7.1);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(subjectDTO);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Tomas");
        studentDTO.setAverageScore(7.1);
        studentDTO.setSubjects(listSubject);

        //output
        StudentDTO responseStudenDTO;
        StudentDAO studentDAO = new StudentDAO();

        //Act
        studentDAO.save(studentDTO);
        responseStudenDTO = studentDAO.findById(idStudent);

        //Assert
        assertEquals(studentDTO, responseStudenDTO);

    }

    @Test
    public void deleteTest() {
        //Arrange
        Long idStudent = 26L;
        StudentDAO studentDAO = new StudentDAO();

        //Act
        boolean response = studentDAO.delete(idStudent);

        //Assert
        assertFalse(response);
    }

}
