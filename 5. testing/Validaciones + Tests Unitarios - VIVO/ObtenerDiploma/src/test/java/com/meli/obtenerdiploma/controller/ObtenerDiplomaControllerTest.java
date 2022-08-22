package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.Utiles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController diplomaController;


    @Test
    void testAnalyzeScores() {
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        diplomaController.analyzeScores(student.getId());
        verify(diplomaService, atLeastOnce()).analyzeScores(student.getId());
    }
}