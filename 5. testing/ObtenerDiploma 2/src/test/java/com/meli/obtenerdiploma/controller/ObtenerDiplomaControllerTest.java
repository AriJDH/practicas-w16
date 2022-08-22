package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    void obtenerDiplomaControllerTest(){
        SubjectDTO subject1= new SubjectDTO("Math",9.0);
        SubjectDTO subject2= new SubjectDTO("Math",10.0);

        StudentDTO expected = new StudentDTO(1l,"Juan","Felicitaciones",9.5, List.of(subject1,subject2));

        when(service.analyzeScores(1l)).thenReturn(expected);

        StudentDTO response = controller.analyzeScores(1l);

        verify(service, atLeastOnce()).analyzeScores(1l);

        Assertions.assertEquals(expected,response);

    }
}
