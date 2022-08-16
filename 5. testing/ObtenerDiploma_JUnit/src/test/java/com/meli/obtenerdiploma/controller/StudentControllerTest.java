package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void givenStudentThenRegister(){

        StudentDTO expected = new StudentDTO(1L, "Gabriela Mejia", "Excelent", 4.7, List.of(new SubjectDTO("Math", 4.6)));

        doNothing().when(studentService).create(expected);

        studentController.registerStudent(expected);

        assertNotNull(expected);
    }

    @Test
    public void givenIdThenGetStudent(){

        StudentDTO expected = new StudentDTO(1L, "Gabriela Mejia", "Excelent", 4.7, List.of(new SubjectDTO("Math", 4.6)));

        when(studentService.read(1L)).thenReturn(expected);

        var actual = studentController.getStudent(1L);

        assertEquals(expected, actual);
    }

    @Test
    public void getListOfStudents(){

        Set<StudentDTO> studentsDTO = new HashSet<>(List.of(new StudentDTO(1L, "Gabriela", "No message", 4.5, List.of(new SubjectDTO("Science", 4.0))),
                new StudentDTO(3L, "Guille", "Hello", 3.5, List.of(new SubjectDTO("Math", 4.5)))));


        when(studentService.getAll()).thenReturn(studentsDTO);

        var actual = studentController.listStudents();

        assertEquals(studentsDTO, actual);

    }
}