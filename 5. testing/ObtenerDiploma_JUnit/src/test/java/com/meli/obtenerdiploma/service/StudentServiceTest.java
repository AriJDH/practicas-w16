package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void givenNewStudentThenSave(){

        //Preguntar


        //Arrange
        StudentDTO newStudent = new StudentDTO(null, "Nico", "No message", 4.5,
                List.of(new SubjectDTO("Science", 4.0)));


        doNothing().when(studentDAO).save(newStudent);


        //Act
        studentService.create(newStudent);


        //Assert
        Assertions.assertTrue(studentDAO.exists(newStudent), "");

    }

    @Test
    public void givenStudentThenRead(){

        //Arrange
        StudentDTO studentDTO = new StudentDTO(50L, "Nico", "No message", 4.5,
                List.of(new SubjectDTO("Science", 4.0)));

        when(studentDAO.findById(any())).thenReturn(studentDTO);


        //Act
        StudentDTO actual = studentService.read(50L);


        //Assert
        assertEquals(studentDTO, actual);

    }

    @Test
    public void givenStudentThenUpdate(){

        StudentDTO studentDTO = new StudentDTO(1L,"Gabriela","No message",4.5, List.of(new SubjectDTO("Science", 4.0)));

        studentService.create(studentDTO);
        studentDTO.setStudentName("Maria");
        studentDTO.setMessage("Hello");

        studentService.update(studentDTO);

        StudentDTO actual = studentDAO.findById(studentDTO.getId());


        assertNotEquals(studentDTO,actual);

    }

    @Test
    public void getAllStudents(){

        Set<StudentDTO> studentsDTO = new HashSet<>(List.of(new StudentDTO(1L, "Gabriela", "No message", 4.5, List.of(new SubjectDTO("Science", 4.0))),
                new StudentDTO(3L, "Guille", "Hello", 3.5, List.of(new SubjectDTO("Math", 4.5)))));


                when(studentRepository.findAll()).thenReturn(studentsDTO);

        var all = studentService.getAll();

        assertEquals(studentsDTO,all);

    }

}