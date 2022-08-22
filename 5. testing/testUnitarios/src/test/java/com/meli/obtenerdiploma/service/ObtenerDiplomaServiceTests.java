package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
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
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO mockStudentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void averageScoreWellCalculated() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(mockStudentDAO.findById(stu.getId())).thenReturn(stu);
        //Act
        service.analyzeScores(stu.getId());
        //Assert
        verify(mockStudentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals(6.0, stu.getAverageScore());
    }

    @Test
    public void averageScoreOver9MessageWellWritten() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marco");
        when(mockStudentDAO.findById(stu.getId())).thenReturn(stu);
        //Act
        service.analyzeScores(stu.getId());
        //Assert
        verify(mockStudentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 9. Felicitaciones!", stu.getMessage());
    }

    @Test
    public void averageScoreBelow9MessageWellWritten() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(mockStudentDAO.findById(stu.getId())).thenReturn(stu);
        //Act
        service.analyzeScores(stu.getId());
        //Assert
        verify(mockStudentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("El alumno Marco ha obtenido un promedio de 6. Puedes mejorar.", stu.getMessage());
    }

    @Test
    public void RequestStudentNameMatchesResponseStudentName() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(mockStudentDAO.findById(stu.getId())).thenReturn(stu);
        //Act
        service.analyzeScores(stu.getId());
        //Assert
        verify(mockStudentDAO, atLeastOnce()).findById(stu.getId());
        assertEquals("Marco", stu.getStudentName());
    }

    @Test
    public void RequestStudentSubjectListMatchesResponseSubjectList() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        List<SubjectDTO> initalList = new ArrayList<>();
        stu.getSubjects().stream().forEach((s) -> initalList.add(s));
        when(mockStudentDAO.findById(stu.getId())).thenReturn(stu);
        //Act
        service.analyzeScores(stu.getId());
        //Assert
        verify(mockStudentDAO, atLeastOnce()).findById(stu.getId());
        assertTrue(CollectionUtils.isEqualCollection(initalList, stu.getSubjects()));
    }
}
