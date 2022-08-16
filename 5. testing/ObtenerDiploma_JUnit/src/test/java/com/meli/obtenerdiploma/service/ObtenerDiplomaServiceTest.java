package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void givenExistingStudentThenAnalyzeScore(){

        StudentDTO studentDTO = new StudentDTO(11L, "Gabriela", null, null,
                List.of(new SubjectDTO("Math", 4.5), new SubjectDTO("English", 5.0)));

        when(studentDAO.findById(any())).thenReturn(studentDTO);

        StudentDTO actual = service.analyzeScores(11L);



        //Expected
        StudentDTO expected =  new StudentDTO(11L, "Gabriela", "El alumno " + actual.getStudentName() + " ha obtenido un promedio de " + new DecimalFormat("#.##").format(actual.getAverageScore())
                + ((actual.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar."), 4.75,
                List.of(new SubjectDTO("Math", 4.5), new SubjectDTO("English", 5.0)));


        Assertions.assertEquals(expected, actual);

    }

    @Test
    void givenNonExistingStudentThenNotFound() {
        when(studentDAO.findById(null)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(null));
    }

}