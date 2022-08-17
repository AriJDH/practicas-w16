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
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresNullSubjectListExceptionTest() {
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(null));
    }

    @Test
    public void analyzeScoresFindByIdReturnNullStudentTest() {
        when(studentDAO.findById(10L)).thenReturn(null);
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(10L));
    }

    @Test
    public void analyzeScoresFindByIdReturnNotNullStudentWithNullSubjectTest() {
        StudentDTO student = new StudentDTO();
        student.setId(10L);
        when(studentDAO.findById(10L)).thenReturn(student);
        Assertions.assertThrows(NullPointerException.class, () -> obtenerDiplomaService.analyzeScores(10L));
    }

    @Test
    public void analyzeScoresFindByIdReturnNotNullStudentWithEmptySubjectTest() {
        StudentDTO student = new StudentDTO();
        student.setId(10L);
        student.setStudentName("Pedro");
        student.setSubjects(new ArrayList<>());
        when(studentDAO.findById(10L)).thenReturn(student);
        student = obtenerDiplomaService.analyzeScores(10L);
        Assertions.assertTrue(student.getAverageScore().isNaN());
    }


    @Test
    public void analyzeScoresFindByIdReturnNotNullStudentWithNotEmptySubjectTest() {
        StudentDTO student = new StudentDTO();
        student.setId(10L);
        student.setStudentName("Pedro");
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(new SubjectDTO("Juan", 10d));
        subjects.add(new SubjectDTO("Marcos", 9d));
        student.setSubjects(subjects);
        when(studentDAO.findById(10L)).thenReturn(student);
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(10L);
        Assertions.assertEquals(student,resultStudent );
        Assertions.assertEquals(9.5d, student.getAverageScore());

        Assertions.assertTrue(student.getMessage().contains("El alumno Pedro ha obtenido un promedio de 9.5"));
        Assertions.assertTrue(student.getMessage().contains(". Felicitaciones!"));

    }

    @Test
    public void analyzeScoresFindByIdReturnStudentWithAvergaLowerThan9Test() {
        StudentDTO student = new StudentDTO();
        student.setId(10L);
        student.setStudentName("Pedro");
        List<SubjectDTO> subjects = new ArrayList<SubjectDTO>();
        subjects.add(new SubjectDTO("Marcos", 10d));
        subjects.add(new SubjectDTO("Juan", 6d));
        student.setSubjects(subjects);
        when(studentDAO.findById(10L)).thenReturn(student);
        StudentDTO resultStudent = obtenerDiplomaService.analyzeScores(10L);
        Assertions.assertEquals(student,resultStudent );
        Assertions.assertEquals(8d, student.getAverageScore());
        Assertions.assertTrue(student.getMessage().contains("El alumno Pedro ha obtenido un promedio de 8."));
        Assertions.assertTrue(student.getMessage().contains(". Puedes mejorar."));
    }
}
