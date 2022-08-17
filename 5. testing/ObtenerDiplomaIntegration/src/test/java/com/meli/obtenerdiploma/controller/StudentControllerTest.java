package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController controller;

    @Test
    void testRegisterStudent() {
        //Arrange
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", 1L);

        //Act
        controller.registerStudent(student);

        //Assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).create(student);
    }

    @Test
    void testGetStudent() {
        //Arrange
        long id = 1L;
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", id);
        Mockito.when(studentService.read(id)).thenReturn(student);
        //Act
        StudentDTO response = controller.getStudent(id);

        //Assert
        Assertions.assertEquals(student, response);
        Mockito.verify(studentService, Mockito.atLeastOnce()).read(id);
    }

    @Test
    void testModifyStudent() {
        //Arrange
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", 1L);

        //Act
        controller.modifyStudent(student);

        //Assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).update(student);
    }

    @Test
    void testRemoveStudent() {
        //Arrange
        long id = 1L;
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", id);

        //Act
        controller.removeStudent(id);

        //Assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).delete(id);
    }

    @Test
    void testListStudents() {
        //Arrange
        StudentDTO s1 = TestUtils.generateStudentNoSubjects("John", 1L);
        StudentDTO s2 = TestUtils.generateStudentNoSubjects("Doe", 2L);
        StudentDTO s3 = TestUtils.generateStudentNoSubjects("JD", 3L);
        Set<StudentDTO> students = new HashSet<>(){{
            add(s1);
            add(s2);
            add(s3);
        }};
        Mockito.when(studentService.getAll()).thenReturn(students);

        //Act
        Set<StudentDTO> response = controller.listStudents();

        //Assert
        assertTrue(CollectionUtils.isEqualCollection(students, response));
        Mockito.verify(studentService, Mockito.atLeastOnce()).getAll();
    }
}