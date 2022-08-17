package com.meli.obtenerdiploma.service;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.CollectionUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceWMocks {
    @Mock
    private IStudentDAO studentDAO;

    @Mock
    private IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    public void CreateStudent(){
        //Arrange
        StudentDTO sampleStudent = new StudentDTO(1L,"Juan","",0D, Arrays.asList(new SubjectDTO("matematica",8D),new SubjectDTO("fisica",7D)));
        //Act
        studentService.create(sampleStudent);
        //Assert
        verify(studentDAO,atLeastOnce()).save(sampleStudent);
    }

    @Test
    public void readStudentTest(){
        //Arrange
        StudentDTO sampleStudent = new StudentDTO(1L,"Juan","",0D, Arrays.asList(new SubjectDTO("matematica",8D),new SubjectDTO("fisica",7D)));
        when(studentDAO.findById(sampleStudent.getId())).thenReturn(sampleStudent);
        //Act
        StudentDTO returnStudent = studentService.read(sampleStudent.getId());
        //Assert
        verify(studentDAO,atLeastOnce()).findById(sampleStudent.getId());
        Assertions.assertEquals(sampleStudent,returnStudent);
    }
    @Test
    public void updateStudent(){
        //Arrange
        StudentDTO sampleStudent = new StudentDTO(1L,"Juan","",0D, Arrays.asList(new SubjectDTO("matematica",8D),new SubjectDTO("fisica",7D)));
        //Act
        studentService.update(sampleStudent);
        //Assert
        verify(studentDAO,atLeastOnce()).save(sampleStudent);
    }
    @Test
    public void deleteStudentTest(){
        //Arrange
        StudentDTO sampleStudent = new StudentDTO(1L,"Juan","",0D, Arrays.asList(new SubjectDTO("matematica",8D),new SubjectDTO("fisica",7D)));
        //Act
        studentService.delete(sampleStudent.getId());
        //Assert
        verify(studentDAO,atLeastOnce()).delete(sampleStudent.getId());
    }
    @Test
    public void findAllStudentsTest(){
        //Arrange
        StudentDTO sampleStudent = new StudentDTO(1L,"Juan","",0D, Arrays.asList(new SubjectDTO("matematica",8D),new SubjectDTO("fisica",7D)));
        StudentDTO sampleStudent2 = new StudentDTO(1L,"pepe","",0D, Arrays.asList(new SubjectDTO("matematica",8D),new SubjectDTO("fisica",7D)));
        Set<StudentDTO> studentSet = new HashSet<>(Arrays.asList(sampleStudent,sampleStudent2));
        when(studentRepository.findAll()).thenReturn(studentSet);
        //Act
        Set<StudentDTO> resultSet = studentService.studentRepository.findAll();
        //Assert
        verify(studentRepository,atLeastOnce()).findAll();
        Assertions.assertEquals(studentSet.size(),resultSet.size());
        Assertions.assertEquals(studentSet.stream().findFirst(),resultSet.stream().findFirst());
    }

}
