package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObetenerDiplomaServiceWMoks {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void AnalyzeScoreTest(){
        //Arrange
        StudentDTO sampleStudent = new StudentDTO(1L,"Juan","",0D, Arrays.asList(new SubjectDTO("matematica",8D),new SubjectDTO("fisica",7D)));
        when(studentDAO.findById(anyLong())).thenReturn(sampleStudent);
        //Act
        StudentDTO returnStudent = obtenerDiplomaService.analyzeScores(1L);
        //Assert
        Assertions.assertEquals(7.5,returnStudent.getAverageScore());
    }
}
