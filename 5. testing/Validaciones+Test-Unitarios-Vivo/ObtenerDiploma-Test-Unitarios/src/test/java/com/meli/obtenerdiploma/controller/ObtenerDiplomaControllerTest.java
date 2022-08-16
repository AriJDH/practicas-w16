package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTest(){

        //Arrange
        Long idStudent = 64L;

        SubjectDTO materiaUno = new SubjectDTO();
        materiaUno.setName("Ortografía");
        materiaUno.setScore(6.3);

        SubjectDTO materiaDos = new SubjectDTO();
        materiaDos.setName("Sociales");
        materiaDos.setScore(7.1);

        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(materiaUno);
        listSubject.add(materiaDos);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(idStudent);
        studentDTO.setStudentName("Álvaro");
        studentDTO.setAverageScore(6.7);
        studentDTO.setSubjects(listSubject);

        when(iObtenerDiplomaService.analyzeScores(idStudent)).thenReturn(studentDTO);

        //Act
        StudentDTO resultStudentDTO;
        resultStudentDTO = obtenerDiplomaController.analyzeScores(idStudent);

        //Assert
        assertEquals(resultStudentDTO, studentDTO);

    }

}
