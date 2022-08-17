package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class Ejercicio2 {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    private StudentDTO expectedStu;

    @BeforeEach
    void setUp() {
        expectedStu = new StudentDTO(1L,"Javier","",null,null);

    }



    @Test
    void checkAverageScoreCanImprove(){
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matematica",8.0));
        list.add(new SubjectDTO("Matematica",4.0));

        expectedStu.setSubjects(list);

        when(studentDAO.findById(1L)).thenReturn(expectedStu);

        StudentDTO studentWithScore = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(6.0, studentWithScore.getAverageScore());
        assertEquals("El alumno Javier ha obtenido un promedio de 6. Puedes mejorar.", studentWithScore.getMessage());
    }

    @Test
    void checkAverageScoreIsOutstanding(){
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matematica",9.0));
        list.add(new SubjectDTO("Matematica",10.0));

        expectedStu.setSubjects(list);

        when(studentDAO.findById(1L)).thenReturn(expectedStu);

        StudentDTO studentWithScore = obtenerDiplomaService.analyzeScores(1L);

        assertEquals(9.5, studentWithScore.getAverageScore());
        assertEquals("El alumno Javier ha obtenido un promedio de 9.5. Felicitaciones!", studentWithScore.getMessage());
    }



}
