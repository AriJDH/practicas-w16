package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void obtenerPromedioTest(){

        //Arrange
        StudentDTO student = new StudentDTO(123L, "German", "", 0.0,
                new ArrayList<>(Arrays.asList(
                        new SubjectDTO("Matematica", 50.0),
                        new SubjectDTO("Fisica", 100.0))
                )
        );

        when(studentDAO.findById(student.getId())).thenReturn(student);

        //Act
        obtenerDiplomaService.analyzeScores(123L);

        //Assert
        assertEquals(75.0, student.getAverageScore());
    }

    @Test
    public void obtenerMessageTest(){

        //Arrange
        StudentDTO student = new StudentDTO(123L, "German", "", 0.0,
                new ArrayList<>(Arrays.asList(
                        new SubjectDTO("Matematica", 50.0),
                        new SubjectDTO("Fisica", 100.0))
                )
        );

        when(studentDAO.findById(student.getId())).thenReturn(student);

        String expected = "El alumno German ha obtenido un promedio de 75. Felicitaciones!";

        //Act
        obtenerDiplomaService.analyzeScores(123L);

        //Assert
        assertEquals(expected, student.getMessage());
    }

    @Test
    public void obtenerMessageLowAverageTest(){

        //Arrange
        StudentDTO student = new StudentDTO(123L, "German", "", 0.0,
                new ArrayList<>(Arrays.asList(
                        new SubjectDTO("Matematica", 5.0),
                        new SubjectDTO("Fisica", 10.0))
                )
        );

        when(studentDAO.findById(student.getId())).thenReturn(student);

        String expected = "El alumno German ha obtenido un promedio de 7.5. Puedes mejorar.";

        //Act
        obtenerDiplomaService.analyzeScores(123L);

        //Assert
        assertEquals(expected, student.getMessage());
    }
}
