package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Mock
    IObtenerDiplomaService diplomaService;

    @InjectMocks
    ObtenerDiplomaController diplomaController;

    @Test
    public void obtenerDiploma() {

        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 7.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        diplomaController.analyzeScores(studentDTO.getId());

        verify(diplomaService, atLeastOnce()).analyzeScores(studentDTO.getId());
    }
}
