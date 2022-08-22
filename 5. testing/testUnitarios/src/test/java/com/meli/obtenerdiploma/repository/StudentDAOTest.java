package com.meli.obtenerdiploma.repository;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    IStudentDAO studentDAO;

    @BeforeEach
    @AfterEach
    public void setUp() {
        TestUtilsGenerator.emptyUsersFile();
        this.studentDAO = new StudentDAO();
    }

    @Test
    public void createNonExistentStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //Act
        studentDAO.save(stu);
        //Assert
        assertTrue(studentDAO.exists((stu)));
        assertEquals(1L, stu.getId());
        assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void createExistentStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //Act
        studentDAO.save(stu);
        //Assert
        assertTrue(studentDAO.exists(stu));
        assertEquals(1L, stu.getId());
        assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void modifyNonExistentStudent() {
        //Arrange
        StudentDTO stu1 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        StudentDTO stu2 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu2.setId(999L);
        stu2.setStudentName("Marco Polo");
        studentDAO.save(stu1);
        //Act
        studentDAO.save(stu2);
        //Assert
        assertTrue(studentDAO.exists(stu1));
        assertEquals(1L, stu1.getId());
        assertEquals(studentDAO.findById(stu1.getId()), stu1);

        assertTrue(studentDAO.exists(stu2));
        assertEquals(2L, stu2.getId());
        assertEquals(studentDAO.findById(stu2.getId()), stu2);
    }

    @Test
    public void modifyExistentStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);
        //Act
        stu.setStudentName("Marco Polo");
        studentDAO.save(stu);
        //Assert
        assertTrue(studentDAO.exists(stu));
        assertEquals(1L, stu.getId());
        assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void findExistentStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);
        //Act
        StudentDTO found = studentDAO.findById(stu.getId());
        //Assert
        assertEquals(found, stu);
    }

    @Test
    public void findNonExistentStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //Act & Assert
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteExistentStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);
        //Act
        studentDAO.delete(stu.getId());
        //Assert
        assertFalse(studentDAO.exists(stu));
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteNonExistentStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //Act
        studentDAO.delete(stu.getId());
        //Assert
        assertFalse(studentDAO.exists(stu));
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }
}
