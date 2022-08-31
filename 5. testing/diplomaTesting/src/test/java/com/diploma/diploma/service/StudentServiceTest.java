package com.diploma.diploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.repository.IStudentDAO;
import com.diploma.diploma.repository.StudentRepository;
import com.diploma.util.UtilTestTools;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;


    @Test
    public void createStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Cristian");

        //Act
        studentService.create(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);

    }

    @Test
    public void readStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Cristian");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        StudentDTO readStudent = studentService.read(student.getId());
        
        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(readStudent, student);
    }
    
    @Test
    public void updateStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Alberto");

        //Act
        studentService.update(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    public void deleteStudent(){
        StudentDTO student = UtilTestTools.generateStudent("Alberto");

        //Act
        studentService.delete(student.getId());

        //Assert
        verify(studentDAO, atLeastOnce()).delete(student.getId());
        assertNull(studentService.read(student.getId()));
    }
    // getAll() {
}
