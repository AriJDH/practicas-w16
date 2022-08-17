package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    void testAnalyzeLowScores() {
        //Arrange
        long id = 1L;
        StudentDTO student = TestUtils.generateNormalStudent("student", id);
        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO response = service.analyzeScores(id);

        //Assert
        Assertions.assertEquals(student, response);
        double average = student.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        Assertions.assertEquals(average, response.getAverageScore(), 0.000001);
        Assertions.assertTrue(response.getMessage().endsWith("Puedes mejorar."));
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    void testAnalyzeHighScores() {
        //Arrange
        long id = 1L;
        StudentDTO student = TestUtils.generateHonoredStudent("student", id);
        Mockito.when(studentDAO.findById(id)).thenReturn(student);

        //Act
        StudentDTO response = service.analyzeScores(id);

        //Assert
        Assertions.assertEquals(student, response);
        double average = student.getSubjects().stream().mapToDouble(SubjectDTO::getScore).average().getAsDouble();
        Assertions.assertEquals(average, response.getAverageScore(), 0.000001);
        Assertions.assertTrue(response.getMessage().endsWith("Felicitaciones!"));
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
    }

    @Test
    void testAnalyzeNotFound() {
        //Arrange
        long id = 1L;
        Mockito.when(studentDAO.findById(id)).thenThrow(new StudentNotFoundException(id));

        //Act & Assert
        Assertions.assertThrows(StudentNotFoundException.class, () -> service.analyzeScores(id));
        Mockito.verify(studentDAO, Mockito.atLeastOnce()).findById(id);
    }
}