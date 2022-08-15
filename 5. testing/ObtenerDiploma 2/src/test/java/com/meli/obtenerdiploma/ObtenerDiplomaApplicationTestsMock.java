package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaApplicationTestsMock {

    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService ;


    @Test
    void analyzeScores() {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO sub1 = new SubjectDTO("Maths",1.0);
        subjects.add(sub1);

        StudentDTO expectedStudent = new StudentDTO(19L,"Sofia","Hay que mejorar!",1.0,subjects);
        when(studentDAO.findById(19L)).thenReturn(expectedStudent);

        StudentDTO user = obtenerDiplomaService.analyzeScores(19L);

        verify(studentDAO, atLeast(1)).findById(19L);
        Assertions.assertEquals(expectedStudent, user);
    }

    @Test
    void analyzeScores2() {
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO sub1 = new SubjectDTO("Maths",8.5);
        subjects.add(sub1);

        StudentDTO expectedStudent = new StudentDTO(20L,"Juan","Felicitaciones!",8.5,subjects);
        when(studentDAO.findById(20L)).thenReturn(expectedStudent);

        StudentDTO user = obtenerDiplomaService.analyzeScores(20L);

        verify(studentDAO, atLeast(1)).findById(20L);
        Assertions.assertEquals(expectedStudent, user);
    }

    @Test
    void analyzeScoresNull() {
        when(studentDAO.findById(null)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }

    @Test
    void analyzeScoresInvalid() {
        when(studentDAO.findById(12345L)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, () -> obtenerDiplomaService.analyzeScores(12345L));

    }
}
