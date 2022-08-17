package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Executable;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    StudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    void testCreate() {
        //Arrange
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", 99L);

        //Act
        service.create(student);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(student);
    }

    @Test
    void testReadExisting() {
        //Arrange
        long id = 1;
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", id);
        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO response = service.read(id);

        //Assert
        Assertions.assertEquals(student, response);
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    void testReadNonexistent() {
        //Arrange
        long id = 1;
        Mockito.when(studentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));

        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> service.read(id));
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    void testUpdate() {
        //Arrange
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", 99L);

        //Act
        service.update(student);

        //Assert
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).save(student);
    }

    @Test
    void testDelete() {
        //Arrange
        StudentDTO student = TestUtils.generateStudent2Subjects("Student", 1L);

        //Act
        service.delete(student.getId());

        //Assert
        verify(studentDAO, atLeastOnce()).delete(student.getId());
    }

    @Test
    void getAll() {
        //Arrange
        StudentDTO s1 = TestUtils.generateStudentNoSubjects("John", 1L);
        StudentDTO s2 = TestUtils.generateStudentNoSubjects("Doe", 2L);
        StudentDTO s3 = TestUtils.generateStudentNoSubjects("JD", 3L);
        Set<StudentDTO> students = new HashSet<>(){{
            add(s1);
            add(s2);
            add(s3);
        }};
        when(studentRepository.findAll()).thenReturn(students);

        //Act
        Set<StudentDTO> response = service.getAll();

        //Assert
        assertTrue(CollectionUtils.isEqualCollection(students, response));
        verify(studentRepository, atLeastOnce()).findAll();
    }
}