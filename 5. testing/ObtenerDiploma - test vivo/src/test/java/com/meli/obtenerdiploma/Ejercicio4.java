package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Ejercicio4 {
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    void shouldReturnAverageScoreAndMessageForStudentIdWhenAnalyzeScore() {
        //Arrange
        var studentId = 1L;
        List<SubjectDTO> subjectsMocked = new ArrayList<>();
        subjectsMocked.add(new SubjectDTO("Literatura", 10.0));
        var studentMocked = new StudentDTO(studentId, "Ricardito", ("El alumno " + "Pepe Tests" + " ha obtenido un promedio de 10.0. Felicitaciones!"), 10.0, subjectsMocked);

        Mockito.when(obtenerDiplomaService.analyzeScores(studentId))
                .thenReturn(studentMocked);

        //Act
        StudentDTO obtainedResult = obtenerDiplomaController.analyzeScores(studentId);

        //Assert
        Assertions.assertThat(obtainedResult).isEqualTo(studentMocked);
        Mockito.verify(obtenerDiplomaService, Mockito.atMostOnce()).analyzeScores(studentId);
    }

    @Test
    void analizeScoreForUserNotCreated() {
        long nullUserId = 1L;
        Mockito.when(obtenerDiplomaService.analyzeScores(nullUserId))
                .thenThrow(new StudentNotFoundException(nullUserId));

        Assertions.assertThatThrownBy(() -> obtenerDiplomaController.analyzeScores(nullUserId))
                .isInstanceOf(StudentNotFoundException.class);
    }
}
