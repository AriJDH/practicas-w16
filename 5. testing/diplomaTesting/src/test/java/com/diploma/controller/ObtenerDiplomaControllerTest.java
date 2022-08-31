package com.diploma.controller;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.diploma.diploma.controller.ObtenerDiplomaController;
import com.diploma.diploma.model.StudentDTO;
import com.diploma.diploma.service.IObtenerDiplomaService;
import com.diploma.util.UtilTestTools;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    
    @Mock
    IObtenerDiplomaService obtenerDiplomaService;
    
    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    public void calculateAverage(){
        //Arrange
        StudentDTO student = UtilTestTools.generateStudent("Pedro");

        //Act
        obtenerDiplomaController.analyzeScores(student.getId());

        //Assert
        verify(obtenerDiplomaService, atLeastOnce()).analyzeScores(student.getId());
    }
}
