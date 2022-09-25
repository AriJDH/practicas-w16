package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void registerStudent() {
        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);

        studentController.registerStudent(student);

        verify(iStudentService, atLeastOnce()).create(student);

    }

    @Test
    void getStudent() {
        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);

        studentController.getStudent(student.getId());

        verify(iStudentService, atLeastOnce()).read(student.getId());
    }

    @Test
    void modifyStudent() {
        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);

        studentController.modifyStudent(student);

        verify(iStudentService, atLeastOnce()).update(student);
    }

    @Test
    void removeStudent() {
        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);

        studentController.removeStudent(student.getId());

        verify(iStudentService, atLeastOnce()).delete(student.getId());
    }

    @Test
    void listStudents() {
        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);

        Set<StudentDTO> todos= new HashSet<>();
        todos.add(student);
        when(iStudentService.getAll()).thenReturn(todos);

        Set<StudentDTO> listStudent = studentController.listStudents();

        verify(iStudentService,atLeastOnce()).getAll();
        //assertTrue(CollectionUtils.isEqualCollection(todos, listStudent));

    }
}