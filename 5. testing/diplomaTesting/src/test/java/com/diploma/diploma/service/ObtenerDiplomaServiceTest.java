package com.diploma.diploma.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.repository.IStudentDAO;
import com.diploma.util.UtilTestTools;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test 
    public void averageScoreOver9MessageWellWritten(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithAverage(9.1);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        obtenerDiplomaService.analyzeScores(student.getId());

        //Assert
        verify(studentDAO, times(1)).findById(student.getId());
        assertEquals(
            String.format(
                "El alumno %s ha obtenido un promedio de 9.1. %s",
                student.getStudentName(),
                UtilTestTools.getMessageAccordingToAverage(9.1)
            ),
            student.getMessage()
        );
    }

    @Test 
    public void averageScoreBelow9MessageWellWritten(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudentWithAverage(6.8);
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        obtenerDiplomaService.analyzeScores(student.getId());

        //Assert
        verify(studentDAO, times(1)).findById(student.getId());
        assertEquals(
            String.format(
                "El alumno %s ha obtenido un promedio de 6.8. %s",
                student.getStudentName(),
                UtilTestTools.getMessageAccordingToAverage(6.8)
            ),
            student.getMessage()
        );
    }

    @Test 
    public void averageWellCalculated(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Santiago");
        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        obtenerDiplomaService.analyzeScores(student.getId());

        //Assert
        verify(studentDAO, times(1)).findById(student.getId());
        assertEquals(UtilTestTools.calculateAverage(student.getSubjects()), student.getAverageScore());
    }
}
