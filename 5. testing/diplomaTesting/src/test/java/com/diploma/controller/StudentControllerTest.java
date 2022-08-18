package com.diploma.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.diploma.diploma.controller.StudentController;
import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.service.IStudentService;
import com.diploma.util.UtilTestTools;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Francisco");

        //Act
        studentController.registerStudent(student);

        //Asset
        verify(studentService, times(1)).create(student);
    }

    @Test
    public void getStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Francisco");
        when(studentService.read(student.getId())).thenReturn(student);

        //Act
        StudentDTO foundStudent = studentController.getStudent(student.getId());

        //Asset
        verify(studentService, times(1)).read(student.getId());
        assertEquals(student, foundStudent);
    }

    @Test 
    public void modifyStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Francisco");
        
        //Act 
        studentController.modifyStudent(student);

        //Asset
        verify(studentService, times(1)).update(student);
    }

    @Test 
    public void removeStudent(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Francisco");
        
        //Act 
        studentController.removeStudent(student.getId());

        //Asset
        verify(studentService, times(1)).delete(student.getId());
    }

    @Test
    public void getListStudentS(){
        //Arrange
        Set<StudentDTO> students = UtilTestTools.findAll();
        when(studentService.getAll()).thenReturn(students);

        //Act
        Set<StudentDTO> foundStudents = studentController.listStudents();

        //Asset
        verify(studentService, times(1)).getAll();
        assertTrue(UtilTestTools.compareSets(students, foundStudents));
    }
}
