package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;
    private void initData(Double mat,Double leng){
        List<SubjectDTO> subjectDTO=new ArrayList<>();
        subjectDTO.add(new SubjectDTO("Matematicas",mat));
        subjectDTO.add(new SubjectDTO("Lengua",leng));
        StudentDTO students=new StudentDTO(1l,"emanuel","message",1D,subjectDTO);
        when(studentDAO.findById(1l)).thenReturn(students);
    }

    @Test
    void getGreetingAvergeScore(){
        initData(9.9,7.9);

        StudentDTO student=obtenerDiplomaService.analyzeScores(1l);

        assertEquals(8.9,student.getAverageScore());
    }

    @Test
    void getGreetingMessage(){
        initData(9.9,7.9);

        StudentDTO student=obtenerDiplomaService.analyzeScores(1l);

        assertEquals("El alumno emanuel ha obtenido un promedio de 8.9. Puedes mejorar.",student.getMessage());
    }
    @Test
    void getGreetingMessageMajorA9(){
        initData(9.9,8.9);

        StudentDTO student=obtenerDiplomaService.analyzeScores(1l);

        assertEquals("El alumno emanuel ha obtenido un promedio de 9.4. Felicitaciones!",student.getMessage());
    }

}
