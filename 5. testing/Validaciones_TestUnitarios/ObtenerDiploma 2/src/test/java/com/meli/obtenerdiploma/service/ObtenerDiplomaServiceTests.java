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
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    public void calculateAverageTest(){
        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 7.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        iStudentDAO.save(studentDTO);
        when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        diplomaService.analyzeScores(studentDTO.getId());


        verify(iStudentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals(8.0, studentDTO.getAverageScore());

    }

    @Test
    public void getGreetingMessagelowAverage(){
        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 7.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        iStudentDAO.save(studentDTO);
        when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        diplomaService.analyzeScores(studentDTO.getId());


        verify(iStudentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals("El alumno Lucía ha obtenido un promedio de 8. Puedes mejorar.", studentDTO.getMessage());
    }

    @Test
    public void getGreetingMessageHighAverage(){
        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        iStudentDAO.save(studentDTO);
        when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        diplomaService.analyzeScores(studentDTO.getId());


        verify(iStudentDAO, atLeastOnce()).findById(studentDTO.getId());
        Assertions.assertEquals("El alumno Lucía ha obtenido un promedio de 9.5. Felicitaciones!", studentDTO.getMessage());
    }

}
