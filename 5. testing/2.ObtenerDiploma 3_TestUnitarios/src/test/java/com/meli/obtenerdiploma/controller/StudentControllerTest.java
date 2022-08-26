package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
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
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testGetRegisterStudent(){
        //mock
        StudentDTO studentMock =  new StudentDTO(55L, "Gonzalo", "mensaje", 4.5,
                List.of(new SubjectDTO("Sociales", 4.5)));

        studentService.create(studentMock);

        //act
        studentController.registerStudent(studentMock);

        //assert
        assertNotNull(studentMock);
    }

    @Test
    public void testGetStudent(){
        //mock
        StudentDTO studentMock =  new StudentDTO(55L, "Gonzalo", "mensaje", 4.5,
                List.of(new SubjectDTO("Sociales", 4.5)));

        when(studentService.read(studentMock.getId())).thenReturn(studentMock);

        //act
        StudentDTO studentCurrently = studentController.getStudent(studentMock.getId());

        //assert
        assertEquals(studentCurrently, studentMock);
    }

    @Test
    public void testGetListStudent(){
        //mock
        Set<StudentDTO> studentSet = new HashSet<>(List.of(new StudentDTO(30L, "Josefa", "Message", 4.5, List.of(new SubjectDTO("Science", 4.0))),
                new StudentDTO(40L, "Paola", "Message", 3.5, List.of(new SubjectDTO("Math", 4.5)))));

        when(studentService.getAll()).thenReturn(studentSet);

        //act
        Set<StudentDTO> studentsCurrently = studentController.listStudents();

        //assert
        assertEquals(studentSet, studentSet);
    }

}