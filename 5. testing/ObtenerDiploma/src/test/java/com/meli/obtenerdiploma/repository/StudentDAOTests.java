package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

import java.util.ArrayList;
import java.util.List;

@TestInstance(PER_CLASS)
public class StudentDAOTests {

    private StudentDAO studentDAO;

    @BeforeEach
    public void initStudentDAO(){
        this.studentDAO = new StudentDAO();
    }

    @AfterAll
    public void removeTestStudents(){ this.studentDAO.delete(3L); }

    @Test
    public void addFindByIdStudentTest(){
        //Arrange
        SubjectDTO sub1 = new SubjectDTO("Geografía", 7.5);
        SubjectDTO sub2 = new SubjectDTO("Biología", 4.0);
        SubjectDTO sub3 = new SubjectDTO("Inglés", 9.0);
        List<SubjectDTO> subList = new ArrayList<>(List.of(sub1, sub2, sub3));
        StudentDTO expected = new StudentDTO(3L, "Student 1", "Message 1", 8.0, subList);

        //Act
        studentDAO.save(expected);
        StudentDTO result = studentDAO.findById(3L);

        //Assert
        assertEquals(expected, result);
    }

    @Test
    public void notFoundByIdStudentTest(){ assertThrows(StudentNotFoundException.class,()->studentDAO.findById(30L)); }

    @Test
    public void testDelete(){
        //Arrange
        StudentDTO testStudent = new StudentDTO(4L,"","",2D,new ArrayList<>());

        //Act
        studentDAO.save(testStudent);
        studentDAO.delete(4L);

        //Assert
        assertThrows(StudentNotFoundException.class,()->studentDAO.findById(4L));
    }

}
