package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @DisplayName("Verifica el promedio del puntaje de un estudiante existente")
    @Test
    public void testAnalyzeScoresWithValidStudent(){
        //mock arrange\
        StudentDTO studentMock = new StudentDTO(1L, "Gonzalo", null, null,
                List.of(new SubjectDTO("Calculo", 4.5), new SubjectDTO("Sociales", 4.7)));

        when(studentDAO.findById(any())).thenReturn(studentMock);

        //act
        StudentDTO studentDTOCurrently = service.analyzeScores(studentMock.getId());

        //Expected
        StudentDTO expected =  new StudentDTO(1L, "Gonzalo", "El alumno " + studentDTOCurrently.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(studentDTOCurrently.getAverageScore())
                + ((studentDTOCurrently.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."), 4.6,
                List.of(new SubjectDTO("Calculo", 4.5), new SubjectDTO("Sociales", 4.7)));

        //assert
        //Assertions.assertEquals(expected, studentDTOCurrently);
        Assertions.assertEquals(expected.getAverageScore(), studentDTOCurrently.getAverageScore());
        Assertions.assertEquals(expected.getMessage(), studentDTOCurrently.getMessage());
        verify(studentDAO, atLeastOnce()).findById(studentMock.getId());
    }

    @DisplayName("Verifica la excepcion cuando el usuario no es valido")
    @Test
    public void testAnalyzeScoresWithNoValidStudent(){
        //mock arrange\
        when(studentDAO.findById(null)).thenThrow(StudentNotFoundException.class);

        //assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(null));
    }
    
}