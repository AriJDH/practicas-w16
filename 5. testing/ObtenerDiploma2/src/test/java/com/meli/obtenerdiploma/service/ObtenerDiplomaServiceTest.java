package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

  @Mock
  private IStudentDAO IStudentDAO;

  @InjectMocks
  private ObtenerDiplomaService ObtenerDiplomaService;

  @Test
  void analyzeScoresTest(){
    //Arrange
    String mensaje = "El alumno Juan ha obtenido un promedio de 7.3. Puedes mejorar.";
    SubjectDTO matematicas = new SubjectDTO("Matematicas", 9.0);
    SubjectDTO fisica = new SubjectDTO("Fisica", 7.0);
    SubjectDTO quimica = new SubjectDTO("Matematicas", 6.0);
    List<SubjectDTO> notas = Arrays.asList(matematicas, fisica, quimica);
    StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.0, notas);
    when(IStudentDAO.findById(1L)).thenReturn(studentDTO);

    //Act
    ObtenerDiplomaService.analyzeScores(1L);

    //Assert
    assertEquals(7.3, studentDTO.getAverageScore());
    assertEquals(mensaje, studentDTO.getMessage());
    verify(IStudentDAO, atLeastOnce()).findById(1L);

  }
}