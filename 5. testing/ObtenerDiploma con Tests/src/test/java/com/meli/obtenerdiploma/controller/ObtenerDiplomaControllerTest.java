package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DecimalFormat;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void whenAnalyzeScoreForInexistentStudent_throwException() {
        var inexistentId = 9999l;
        Mockito.when(obtenerDiplomaService.analyzeScores(inexistentId))
                .thenThrow(new StudentNotFoundException(inexistentId));

        Assertions.assertThatThrownBy(() -> obtenerDiplomaController.analyzeScores(inexistentId))
                .isInstanceOf(StudentNotFoundException.class);
    }

    @Test
    void shouldReturnAverageScoreAndMessageForStudentIdWhenAnalyzeScore() {
        //Arrange
        var studentId = 1l;
        var subjects = List.of(new SubjectDTO("Matematicas", 10d));
        var student = new StudentDTO(studentId, "Pepe Tests", ("El alumno " + "Pepe Tests" + " ha obtenido un promedio de 10.0. Felicitaciones!"), 9d,subjects);

        Mockito.when(obtenerDiplomaService.analyzeScores(studentId))
                .thenReturn(student);

        //Act
        var obtainedResult = obtenerDiplomaController.analyzeScores(studentId);

        //Assert
        Assertions.assertThat(obtainedResult).isEqualTo(student);
        Mockito.verify(obtenerDiplomaService, Mockito.atMostOnce()).analyzeScores(studentId);
    }
}
