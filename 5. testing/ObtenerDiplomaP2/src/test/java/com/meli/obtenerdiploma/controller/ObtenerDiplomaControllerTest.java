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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService mockObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void analyzeScoresTest() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));
        when(mockObtenerDiplomaService.analyzeScores(studentDTO.getId())).thenReturn(studentDTO);

        var res = obtenerDiplomaController.analyzeScores(studentDTO.getId());
        assertEquals(studentDTO,res);
    }
}
