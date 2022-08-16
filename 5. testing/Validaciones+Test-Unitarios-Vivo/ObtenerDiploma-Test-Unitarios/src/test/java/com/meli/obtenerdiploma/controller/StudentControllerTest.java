package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService iStudentService;

    @InjectMocks
    StudentController studentController;

    @Test
    public void getStudentTest(){

        //Arrange
        //Input
        Long idStudent = 21L;

        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName("Literatura");
        subjectDTO.setScore(6.3);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(subjectDTO);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Alejandro");
        studentDTO.setAverageScore(6.3);
        studentDTO.setSubjects(listSubject);

        when(iStudentService.read(idStudent)).thenReturn(studentDTO);

        //Act
        StudentDTO resultStudentDTO;
        resultStudentDTO = studentController.getStudent(idStudent);

        //Assert
        assertEquals(resultStudentDTO, studentDTO);

    }

}
