package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.Utiles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;


    @Test
    void testRegisterStudent() {
        // arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",9.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);
        // act
        studentController.registerStudent(student);
        // assert
       Mockito.verify(studentService, Mockito.atLeastOnce()).create(student);
    }

    @Test
    void testGetStudent() {
        // arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",9.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);
        when(studentService.read(student.getId())).thenReturn(student);
        // act
        StudentDTO resultStudent=studentController.getStudent(student.getId());
        // assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).read(student.getId());
        assertEquals(student,resultStudent);
    }

    @Test
    void testModifyStudent() {
        // arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",9.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);
        // act
        studentController.modifyStudent(student);
        // assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).update(student);
    }

    @Test
    void testRemoveStudent() {
        // arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",9.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);
        // act
        studentController.removeStudent(student.getId());
        // assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).delete(student.getId());
    }

    @Test
    void testListStudents() {
        // arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",9.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);
        Set<StudentDTO> listStudent = new HashSet<>();
        listStudent.add(student);

        when(studentService.getAll()).thenReturn(listStudent);
        // act
        Set<StudentDTO> resultListStudent=studentController.listStudents();
        // assert
        Mockito.verify(studentService, Mockito.atLeastOnce()).getAll();
        assertEquals(listStudent,resultListStudent);
    }
}