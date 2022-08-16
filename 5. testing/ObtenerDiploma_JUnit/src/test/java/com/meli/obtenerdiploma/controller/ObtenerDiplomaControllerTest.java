package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController diplomaController;

    @Test
    public void givenStudentIdThenAnlyzeScore(){

        StudentDTO expected = new StudentDTO(1L, "Gabriela Mejia", "Excelent", 4.7, List.of(new SubjectDTO("Math", 4.6)));

        when(diplomaService.analyzeScores(1L)).thenReturn(expected);

        var actual = diplomaController.analyzeScores(1L);

        assertEquals(expected, actual);
    }

}