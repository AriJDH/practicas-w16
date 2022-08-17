package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentDAOTest {

    private StudentDAO dao = new StudentDAO();

    @AfterEach
    void cleaDatabase() {
        TestUtils.emptyFile();
        dao = new StudentDAO();
    }

    @Test
    void testSaveNewStudent() {
        //Arrange
        StudentDTO student = TestUtils.generateStudent2Subjects("new student", 99L);

        //Act
        dao.save(student);

        //Assert
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertTrue(dao.exists(student));
        Assertions.assertEquals(student, dao.findById(student.getId()));
    }

    @Test
    void testSaveExistingStudent() {
        //Arrange
        StudentDTO student1 = TestUtils.generateStudentNoSubjects("Stu1", 99L);
        StudentDTO student2 = TestUtils.generateStudent2Subjects("Stu2", 99L);
        dao.save(student1);
        dao.save(student2);
        StudentDTO newStudent1 = TestUtils.generateStudent2Subjects("Student 1", 2L);

        //Act
        dao.save(newStudent1);

        //Assert
        Assertions.assertEquals(2L, newStudent1.getId());
        Assertions.assertTrue(dao.exists(newStudent1));
        Assertions.assertEquals(newStudent1, dao.findById(newStudent1.getId()));
    }

    @Test
    void testDeleteExistingStudent() {
        //Arrange
        StudentDTO student = TestUtils.generateStudentNoSubjects("A student", 99L);
        dao.save(student);

        //Act
        boolean response = dao.delete(student.getId());

        //Assert
        Assertions.assertTrue(response);
        Assertions.assertThrows(StudentNotFoundException.class, () -> dao.findById(student.getId()));
        Assertions.assertFalse(dao.exists(student));
    }

    @Test
    void testDeleteNonexistentStudent() {
        //Arrange
        StudentDTO student1 = TestUtils.generateStudentNoSubjects("Stu1", 99L);
        StudentDTO student2 = TestUtils.generateStudent2Subjects("Stu2", 99L);
        dao.save(student1);
        dao.save(student2);
        StudentDTO student3 = TestUtils.generateStudentNoSubjects("A student", 99L);

        //Act
        boolean response = dao.delete(student3.getId());

        //Assert
        Assertions.assertFalse(response);
        Assertions.assertFalse(dao.exists(student3));
    }

    @Test
    void testFindByIdExistingStudent() {
        //Arrange
        StudentDTO student1 = TestUtils.generateStudentNoSubjects("Stu1", 99L);
        StudentDTO student2 = TestUtils.generateStudent2Subjects("Stu2", 99L);
        dao.save(student1);
        dao.save(student2);

        //Act
        StudentDTO finded = dao.findById(2L);

        //Assert
        Assertions.assertTrue(dao.exists(finded));
        Assertions.assertEquals(student2, finded);
    }

    @Test
    void testFindByIdNonexistentStudent() {
        //Arrange
        StudentDTO student1 = TestUtils.generateStudentNoSubjects("Stu1", 99L);
        dao.save(student1);

        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> dao.findById(2L));
    }
}