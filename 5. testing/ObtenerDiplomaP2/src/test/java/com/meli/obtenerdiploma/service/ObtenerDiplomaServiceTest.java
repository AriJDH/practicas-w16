package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO mockStudentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void testAnalizeScoreOk() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));
        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        assertEquals(obtenerDiplomaService.analyzeScores(studentDTO.getId()), studentDTO);
        verify(mockStudentDAO).findById(studentDTO.getId());
    }

    @Test
    public void testCalculoPromedio() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","hola",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        assertEquals(obtenerDiplomaService.analyzeScores(studentDTO.getId()).getAverageScore(), 10.0);
    }

    @Test
    public void testMensajeDiplomaHonores() {
        StudentDTO studentDTO = new StudentDTO(1L,"Ruben","",10.0, List.of(SubjectDTO.builder().score(10.0).name("Matemáticas").build()));

        when(mockStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);
        assertEquals("El alumno Ruben ha obtenido un promedio de 10. Felicitaciones!",obtenerDiplomaService.analyzeScores(studentDTO.getId()).getMessage() );
    }

}
