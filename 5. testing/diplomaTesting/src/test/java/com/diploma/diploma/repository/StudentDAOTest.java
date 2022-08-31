package com.diploma.diploma.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.diploma.diploma.exceptions.StudentNotFoundException;
import com.diploma.diploma.model.StudentDTO;
import com.diploma.util.UtilTestTools;

@SpringBootTest
public class StudentDAOTest{
    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    public void setUp(){
        UtilTestTools.emptyUsersFile();
        studentDAO = new StudentDAO();
    }

    @Test
    public void createNotExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Marcos", 3L);
        
        //Act
        studentDAO.save(student);

        //Assert
        assertTrue(studentDAO.exists(student));
        assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    public void createExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Pedro", 2L);
        
        //Act
        studentDAO.save(student);

        //Assert
        assertTrue(studentDAO.exists(student));
        assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    public void updateNotExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Francisco", 1L);

        //Act
        studentDAO.save(student);

        //Assert

        assertTrue(studentDAO.exists(student));
        assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    public void updateExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Francisco", 1L);

        //Act
        student.setStudentName("Francisco Antonio");
        studentDAO.save(student);

        //Assert

        assertTrue(studentDAO.exists(student));
        assertEquals(studentDAO.findById(student.getId()), student);
    }

    @Test
    public void findExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Francisco", 1L);
        studentDAO.save(student);
        
        //Act
        StudentDTO studentFound = studentDAO.findById(student.getId());
        
        //Assert
        assertEquals(studentFound, student);
    }

    @Test
    public void findNotExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Francisco", 500L);
        
        //Act & Assert
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(student.getId() + 1));
    }

    @Test
    public void deleteExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Pedro", 2L);
        studentDAO.save(student);
        
        //Act
        studentDAO.delete(student.getId());
        
        //Assert
        assertFalse(studentDAO.exists(student));
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(student.getId()));
    }

    @Test
    public void deleteNotExistingStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithId("Antonio", 4L);

        //Act
        studentDAO.delete(student.getId());
        
        //Assert
        assertFalse(studentDAO.exists(student));
        assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(student.getId()));
    }
}