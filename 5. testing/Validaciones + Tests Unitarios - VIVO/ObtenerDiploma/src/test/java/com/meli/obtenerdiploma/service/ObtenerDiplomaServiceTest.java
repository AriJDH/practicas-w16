package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.Utiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    void testAnalyzeScores() {
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);

        when(studentDAO.findById(student.getId())).thenReturn(student);

        diplomaService.analyzeScores(student.getId());

        Assertions.assertEquals(8.5,student.getAverageScore());

    }

    @Test
    void testGetGreetingMessageHigh(){
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",10.0),
                Utiles.getSubject("Fisica",10.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);

        when(studentDAO.findById(student.getId())).thenReturn(student);

        diplomaService.analyzeScores(student.getId());

        Assertions.assertEquals("El alumno Erika ha obtenido un promedio de 10. Felicitaciones!",student.getMessage());
    }

    @Test
    void testGetGreetingMessageLow(){
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);

        when(studentDAO.findById(student.getId())).thenReturn(student);

        diplomaService.analyzeScores(student.getId());

        Assertions.assertEquals("El alumno Erika ha obtenido un promedio de 8.5. Puedes mejorar.",student.getMessage());
    }
}