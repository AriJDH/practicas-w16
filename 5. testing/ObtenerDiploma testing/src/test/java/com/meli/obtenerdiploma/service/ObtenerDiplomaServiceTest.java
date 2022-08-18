package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO mockStudentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;
    @BeforeEach
    public void setUP(){
    }

    @Test
    public void shouldAnalyzeScoresNormal(){
        //Average
        Long studentId = 15L;
        StudentDTO mockStudentDTO = new StudentDTO();
        mockStudentDTO.setStudentName("Marcos");
        mockStudentDTO.setId(studentId);
        mockStudentDTO.setSubjects(
                Arrays.asList(
                        new SubjectDTO("Matematicas", 6.00),
                        new SubjectDTO("Quimica", 9.00)
                )
        );
        when(mockStudentDAO.findById(studentId)).thenReturn(mockStudentDTO);
        //Act
        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(studentId);
        //Assert
        assertAll(
                ()-> assertEquals(mockStudentDTO.getAverageScore(),studentDTO.getAverageScore()),
                ()-> assertNotNull(studentDTO),
                ()-> assertEquals(mockStudentDTO.getMessage(), studentDTO.getMessage())
        );
    }
    @Test
    public void shouldAnalyzeScoresHonors(){
        //Average
        Long studentId = 15L;
        StudentDTO mockStudentDTO = new StudentDTO();
        mockStudentDTO.setStudentName("Marcos");
        mockStudentDTO.setId(studentId);
        mockStudentDTO.setSubjects(
                Arrays.asList(
                        new SubjectDTO("Matematicas", 10.00),
                        new SubjectDTO("Quimica", 9.00)
                )
        );
        when(mockStudentDAO.findById(studentId)).thenReturn(mockStudentDTO);
        //Act
        StudentDTO studentDTO = obtenerDiplomaService.analyzeScores(studentId);
        //Assert
        assertAll(
                ()-> assertEquals(9.5,studentDTO.getAverageScore()),
                ()-> assertNotNull(studentDTO),
                ()-> assertEquals("El alumno Marcos ha obtenido un promedio de 9.5. Felicitaciones!", studentDTO.getMessage())
        );
    }
}
