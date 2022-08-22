package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService mockObtenerDiplomaService;
    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTest() {
        StudentDTO studentDTO = Util.getNewStudentDTO(1l, "Gonzalo", Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 9.0)
        ));
        studentDTO.setMessage("El alumno Gonzalo ha obtenido un promedio de 9.5. Felicitaciones!");
        studentDTO.setAverageScore(9.5);
        Mockito.when(this.mockObtenerDiplomaService.analyzeScores(1l)).thenReturn(studentDTO);

        StudentDTO studentDTOResult = this.obtenerDiplomaController.analyzeScores(1l);

        Assertions.assertEquals(9.5, studentDTOResult.getAverageScore());
        Assertions.assertEquals("El alumno Gonzalo ha obtenido un promedio de 9.5. Felicitaciones!", studentDTOResult.getMessage());
    }
}
