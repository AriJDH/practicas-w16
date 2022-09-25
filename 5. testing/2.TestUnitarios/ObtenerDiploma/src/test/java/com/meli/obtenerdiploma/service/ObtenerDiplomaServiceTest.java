package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
     ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores() {
        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);
        when(iStudentDAO.findById(student.getId())).thenReturn(student);

        obtenerDiplomaService.analyzeScores(student.getId());

        verify(iStudentDAO, atLeastOnce()).findById(student.getId());
        assertEquals(3.0,student.getAverageScore());
    }

    @Test
    void analyzeScoresMessageBad() {
        SubjectDTO subject = new SubjectDTO("Materia1",3.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",7.0,subjectList);
        when(iStudentDAO.findById(student.getId())).thenReturn(student);

        obtenerDiplomaService.analyzeScores(student.getId());

        verify(iStudentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Yenny ha obtenido un promedio de 3. Puedes mejorar.",student.getMessage());
    }

    @Test
    void analyzeScoresMessageGood() {
        SubjectDTO subject = new SubjectDTO("Materia1",10.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",10.0,subjectList);
        when(iStudentDAO.findById(student.getId())).thenReturn(student);

        obtenerDiplomaService.analyzeScores(student.getId());

        verify(iStudentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("El alumno Yenny ha obtenido un promedio de 10. Felicitaciones!",student.getMessage());
    }

    @Test
    void analyzeScoresName() {
        SubjectDTO subject = new SubjectDTO("Materia1",10.0);

        List<SubjectDTO> subjectList = new ArrayList<>();
        subjectList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Yenny","estudiante 1",10.0,subjectList);
        when(iStudentDAO.findById(student.getId())).thenReturn(student);

        obtenerDiplomaService.analyzeScores(student.getId());

        verify(iStudentDAO, atLeastOnce()).findById(student.getId());
        assertEquals("Yenny",student.getStudentName());
    }
}