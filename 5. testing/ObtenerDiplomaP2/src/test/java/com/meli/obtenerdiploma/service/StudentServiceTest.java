package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO mockStudentDAO;
    @Mock
    IStudentRepository mockStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createTest(){
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        studentService.create(studentDTO);

        assertNotNull(studentDTO);
    }

    @Test
    public void readTest(){
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        mockStudentDAO.save(studentDTO);
        studentService.create(studentDTO);

        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        when(studentService.read(studentDTO.getId())).thenReturn(studentDTO);

        var res2 = studentService.read(studentDTO.getId());
        var res = mockStudentDAO.findById(studentDTO.getId());

        assertNotNull(res);
        assertNotNull(res2);
    }

    @Test
    public void updateTest(){
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        mockStudentDAO.save(studentDTO);
        studentService.create(studentDTO);
        studentDTO.setStudentName("Liz");
        studentDTO.setMessage("chau");

        studentService.update(studentDTO);
        mockStudentDAO.save(studentDTO);

        var res2 = studentService.read(studentDTO.getId());
        var res = mockStudentDAO.findById(studentDTO.getId());

        assertNotEquals(studentDTO,res);
        assertNotEquals(studentDTO,res2);
    }

    @Test
    public void deleteTest(){
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        mockStudentDAO.save(studentDTO);
        studentService.create(studentDTO);

        studentService.delete(studentDTO.getId());
        mockStudentDAO.delete(studentDTO.getId());

        var res2 = studentService.read(studentDTO.getId());
        var res = mockStudentDAO.findById(studentDTO.getId());

        assertNull(res);
        assertNull(res2);
    }

    @Test
    public void getAllTest(){
        var res = mockStudentRepository.findAll();
        var res2 = studentService.getAll();

        assertNotNull(res);
        assertNotNull(res2);
    }


}
