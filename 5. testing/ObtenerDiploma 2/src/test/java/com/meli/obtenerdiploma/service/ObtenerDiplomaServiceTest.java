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
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService service;

    @Test
    public void analyzeScoreLost(){
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO sub1 = new SubjectDTO("Biology",2.0);
        subjects.add(sub1);

        StudentDTO expectedStudent = new StudentDTO(11L,"Juan","Hay que mejorar!",1.0,subjects);
        when(studentDAO.findById(11L)).thenReturn(expectedStudent);

        StudentDTO user = service.analyzeScores(11L);

        verify(studentDAO, atLeast(1)).findById(11L);
        Assertions.assertEquals(expectedStudent, user);

    }
    @Test
    public void analyzeScoreWin(){
        List<SubjectDTO> subjects = new ArrayList<>();
        SubjectDTO sub1 = new SubjectDTO("Biology",2.0);
        subjects.add(sub1);

        StudentDTO expectedStudent = new StudentDTO(11L,"Juan","Felicitaciones!",1.0,subjects);
        when(studentDAO.findById(11L)).thenReturn(expectedStudent);

        StudentDTO user = service.analyzeScores(11L);

        verify(studentDAO, atLeast(1)).findById(11L);
        Assertions.assertEquals(expectedStudent, user);
    }

    @Test
    public void analyzeScoreNull(){
        when(studentDAO.findById(null)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, ()-> service.analyzeScores(null));
    }

    @Test void analyzeScoreInvalid(){
        when(studentDAO.findById(132L)).thenThrow(StudentNotFoundException.class);
        Assertions.assertThrows(StudentNotFoundException.class,()-> service.analyzeScores(132L));
    }

}
