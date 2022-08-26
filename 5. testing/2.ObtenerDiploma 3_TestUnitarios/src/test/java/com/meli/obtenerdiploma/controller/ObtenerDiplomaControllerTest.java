package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    private IObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    private ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void testGetAnalyzeScores(){
        StudentDTO studentMock =  new StudentDTO(15L, "Gonzalo", "mensaje", 4.5,
                List.of(new SubjectDTO("Sociales", 4.5)));

        when(obtenerDiplomaService.analyzeScores(studentMock.getId())).thenReturn(studentMock);

        //act
        StudentDTO studentCurrently = obtenerDiplomaController.analyzeScores(15L);

        //assert
        Assertions.assertEquals(studentMock, studentCurrently);
    }

}