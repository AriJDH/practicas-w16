package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;
    
    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO pepeStudent;
    private List<SubjectDTO> pepeSubjects;

    @BeforeEach
    void setUp() {
        pepeSubjects = List.of(
                new SubjectDTO("Matematicas", 1d)
        );
        pepeStudent = new StudentDTO(null, "Pepe", null, null, pepeSubjects);

    }

    @Test
    void shouldRaiseException_whenAnalyzeScoresForInexistentStudentId() {
        long inexistentStudentId = 9999;
        when(studentDAO.findById(inexistentStudentId))
                        .thenThrow(new StudentNotFoundException(inexistentStudentId));

        Assertions.assertThatThrownBy(() -> obtenerDiplomaService.analyzeScores(inexistentStudentId))
                .isInstanceOf(StudentNotFoundException.class);
    }

    @Test
    void test_studentWithOnlySubjectAndWith1Score() {
        var studentId = 1l;
        when(studentDAO.findById(studentId)).thenReturn(pepeStudent);

        var student = obtenerDiplomaService.analyzeScores(studentId);

        assertThat(student.getAverageScore()).isEqualTo(1);
        assertThat(student.getMessage()).isEqualTo(
                "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(1)
                        + ". Puedes mejorar.");
        verify(studentDAO, atMostOnce()).findById(studentId);
    }

    @Test
    void test_analyzeScoreForStudentWithAverageEqualsTo10() {
        //Arrange
        var studentId = 1l;
        var subjects = List.of(
                new SubjectDTO("Fisica", 10d),
                new SubjectDTO("Geografia", 10d)
        );
        var student = new StudentDTO(studentId, "Pepe Reloaded", null, null, subjects);
        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        var obtainedStudent = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        var expectedAverage = (10d + 10d) / 2;

        assertThat(student.getAverageScore()).isEqualTo(expectedAverage);
        assertThat(student.getMessage()).isEqualTo(
                "El alumno " + student.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(expectedAverage)
                        + ". Felicitaciones!");
        verify(studentDAO, atMostOnce()).findById(studentId);
    }


}
