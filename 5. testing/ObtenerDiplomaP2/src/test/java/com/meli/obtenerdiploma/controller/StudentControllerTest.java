package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.validation.constraints.NotNull;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService mockStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void registerStudentTest() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        studentController.registerStudent(studentDTO);

        assertNotNull(studentDTO);
    }

    @Test
    public void getStudentTest() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        studentController.registerStudent(studentDTO);
        studentController.getStudent(studentDTO.getId());

        assertNotNull(studentDTO);
    }

    @Test
    public void modifyStudentTest() {
        StudentDTO studentDTO = new StudentDTO(1L, "Ruben", "hola", 10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));
        mockStudentService.create(studentDTO);
        studentController.registerStudent(studentDTO);
        studentDTO.setStudentName("Liz");
        studentDTO.setMessage("chau");

        studentController.modifyStudent(studentDTO);
        mockStudentService.update(studentDTO);

        assertNotEquals(studentDTO, studentController.getStudent(studentDTO.getId()));
    }

    @Test
    public void removeStudentTest() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));
        studentController.registerStudent(studentDTO);
        studentController.removeStudent(studentDTO.getId());

        assertNull(studentController.getStudent(studentDTO.getId()));
    }

    @Test
    public void listStudentTest() {
        var students = studentController.listStudents();
        assertNotNull(students);
    }

}
