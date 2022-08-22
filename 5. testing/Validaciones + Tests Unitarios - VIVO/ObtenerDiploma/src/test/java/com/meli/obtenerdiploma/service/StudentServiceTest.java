package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.util.Utiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void testCreate() {
        //Arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);
        //Act
        studentService.create(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);
    }

    @Test
    void read() {
        //Arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        StudentDTO readStudent= studentService.read(student.getId());

        //Assert
        verify(studentDAO, atLeastOnce()).findById(student.getId());
        Assertions.assertEquals(student,readStudent);
    }

    @Test
    void testUpdate() {
        //Arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        //Act

        studentService.update(student);

        //Assert
        verify(studentDAO, atLeastOnce()).save(student);

    }

    @Test
    void testDelete() {
        //Arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        //Act
        studentService.delete(student.getId());

        //Assert
        verify(studentDAO, atLeastOnce()).delete(student.getId());
    }

    @Test
    void testGetAll() {
        //Arrange
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        Set<StudentDTO> listStudent = new HashSet<>();
        listStudent.add(student);

        when(studentRepository.findAll()).thenReturn(listStudent);

        //Act
        Set<StudentDTO> resultListStudent = studentService.getAll();

        //Assert
        verify(studentRepository, atLeastOnce()).findAll();
    }
}