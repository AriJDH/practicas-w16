package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService iObtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;


    @Test
    void analyzeScores() {
        List<SubjectDTO> list = new ArrayList<>();
        SubjectDTO sub1 = new SubjectDTO("Matematica",1.0);
        list.add(sub1);
        StudentDTO expectedStu = new StudentDTO(190L,"Mauricio",". Puedes mejorar.",1.0,list);
        when(iObtenerDiplomaService.analyzeScores(190L)).thenReturn(expectedStu);
        StudentDTO user = obtenerDiplomaController.analyzeScores(190L);
        assertThat(expectedStu).isEqualTo(user);
    }
}