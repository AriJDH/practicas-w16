package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService service;

    @Test
    void readStudent(){
        StudentDTO newStudent = new StudentDTO(111l, "Nico", "No message", 4.5,
                List.of(new SubjectDTO("Science", 4.0)));


        when(service.read(111l)).thenReturn(newStudent);
        //Act
        StudentDTO response = service.read(111l);



        //Assert
        verify(studentDAO, atLeastOnce()).findById(111l);
        Assertions.assertEquals(newStudent,response);

    }

    @Test
    void createStudent(){
        StudentDTO newStudent = new StudentDTO(111l, "Nico", "No message", 4.5,
                List.of(new SubjectDTO("Science", 4.0)));

        when(studentDAO.exists(newStudent)).thenReturn(true);


        Assertions.assertTrue(studentDAO.exists(newStudent));
        verify(studentDAO, atLeastOnce()).exists(newStudent);

    }

    @Test
    void findAll(){
        StudentDTO newStudent = new StudentDTO(111l, "Nico", "No message", 4.5,
                List.of(new SubjectDTO("Science", 4.0)));

        Set<StudentDTO> expected = new HashSet<>();

        expected.add(newStudent);

        when(studentRepository.findAll()).thenReturn(expected);

        Set<StudentDTO> response = service.getAll();

        verify(studentRepository,atLeastOnce()).findAll();
        Assertions.assertEquals(expected,response);
    }




}
