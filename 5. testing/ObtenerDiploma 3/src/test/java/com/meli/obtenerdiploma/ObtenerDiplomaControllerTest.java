package com.meli.obtenerdiploma;
import com.meli.obtenerdiploma.controller.ObtenerDiplomaController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    @Mock
    IObtenerDiplomaService ObtenerDiplomaService;

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    private void initData(){
        List<SubjectDTO> subjectDTO=new ArrayList<>();
        subjectDTO.add(new SubjectDTO("Matematicas",8.9));
        subjectDTO.add(new SubjectDTO("Lengua",9.9));
        StudentDTO students=new StudentDTO(1l,"emanuel","message",1D,subjectDTO);
        when(studentDAO.findById(1l)).thenReturn(students);

        ObtenerDiplomaService.analyzeScores(1l);


    }
    @Test
    public void testController(){
        List<SubjectDTO> subjectDTO=new ArrayList<>();
        subjectDTO.add(new SubjectDTO("Matematicas",8.9));
        subjectDTO.add(new SubjectDTO("Lengua",9.9));
        StudentDTO students=new StudentDTO(1l,"Emanuel","El alumno Emanuel ha obtenido un promedio de 9.4. Felicitaciones!",9.4,subjectDTO);
        when(ObtenerDiplomaService.analyzeScores(1l)).thenReturn(students);



        StudentDTO student=obtenerDiplomaController.analyzeScores(1l);

        assertEquals(9.4,student.getAverageScore());

    }
}
