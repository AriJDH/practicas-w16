package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private StudentDAO studentDAO;
    final static long studentId = 1L;

    @BeforeEach
    void setUp() {
        this.studentDAO = new StudentDAO();
    }

    /*@AfterEach
    void tearDown() {
        try {
            this.studentDAO.delete(studentId);
        } catch (StudentNotFoundException ignored) {
        }
    }*/


    @Test
    void existsTrue() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(studentId, "Test", "Test message", 12.0, new ArrayList<>());
        boolean expectedResult = true;
        this.studentDAO.save(studentDTO);

        // Act
        boolean result = this.studentDAO.exists(studentDTO);

        // Assert
        assertEquals(expectedResult, result);
        this.deleteStudent(studentId);
    }

    @Test
    void existsFalse() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(studentId, "Test", "Test message", 12.0, new ArrayList<>());
        boolean expectedResult = false;

        // Act
        boolean result = this.studentDAO.exists(studentDTO);

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void deleteTrue() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(studentId, "Test", "Test message", 12.0, new ArrayList<>());
        this.studentDAO.save(studentDTO);
        boolean expectedResult = true;

        // Act
        boolean result = this.studentDAO.delete(studentDTO.getId());

        // Assert
        assertEquals(expectedResult, result);
        this.deleteStudent(studentId);
    }

    @Test
    void deleteFalse() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(studentId, "Test", "Test message", 12.0, new ArrayList<>());
        boolean expectedResult = false;

        // Act
        boolean result = this.studentDAO.delete(studentDTO.getId());

        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    void findByIdOk() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(studentId, "Test", "Test message", 12.0, new ArrayList<>());
        this.studentDAO.save(studentDTO);

        StudentDTO expectedResult = studentDTO;

        // Act
        StudentDTO result = this.studentDAO.findById(studentId);

        // Assert
        assertEquals(expectedResult, result);
        this.deleteStudent(studentId);
    }

    @Test
    void findByIdException() {
        // Arrange
        StudentDTO studentDTO = new StudentDTO(studentId, "Test", "Test message", 12.0, new ArrayList<>());
        String expectedResult = "El alumno con Id " + studentId + " no se encuetra registrado.";

        // Act
        StudentNotFoundException thrown = assertThrows(StudentNotFoundException.class, () -> this.studentDAO.findById(studentId));

        // Assert
        assertEquals(expectedResult, thrown.getError().getDescription());
    }

    void deleteStudent(long id) {
        this.studentDAO.delete(id);
    }

    /*@Test
    void test() {
        //this.studentDAO.delete(1L);
        //this.studentDAO.delete(2L);
        //this.studentDAO.delete(3L);
        //this.studentDAO.delete(4L);
        //this.studentDAO.delete(5L);
        this.studentDAO.delete(6L);
        this.studentDAO.delete(7L);
    }*/


}
