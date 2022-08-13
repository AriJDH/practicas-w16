package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    public void analyzeScoresTest(){
        //Arrange
        List<SubjectDTO> scores = new ArrayList<>(List.of(new SubjectDTO("Matemática", 9D), new SubjectDTO("Física", 7D), new SubjectDTO("Química", 6D)));
        StudentDTO expectedFind = new StudentDTO(1L, "Juan", null, null, scores);

        when(studentDAO.findById(expectedFind.getId())).thenReturn(expectedFind);

        expectedFind.setAverageScore(7.333333333333333);
        expectedFind.setMessage("El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.");

        //Act
        StudentDTO result = service.analyzeScores(1L);

        //Assert
        assertEquals(expectedFind, result);
    }

}
