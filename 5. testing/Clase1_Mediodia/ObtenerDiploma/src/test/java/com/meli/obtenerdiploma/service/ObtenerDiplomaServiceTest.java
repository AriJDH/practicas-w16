package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void analyzeScores() {
        List<SubjectDTO> list = new ArrayList<>();
        SubjectDTO sub1 = new SubjectDTO("Matematica",1.0);
        list.add(sub1);
        StudentDTO expectedStu = new StudentDTO(190L,"Mauricio",". Puedes mejorar.",1.0,list);
        when(studentDAO.findById(190L)).thenReturn(expectedStu);
        StudentDTO user = obtenerDiplomaService.analyzeScores(190L);
        assertThat(expectedStu).isEqualTo(user);
    }
    @Test
    void analyzeScores2() {
        List<SubjectDTO> list = new ArrayList<>();
        SubjectDTO sub1 = new SubjectDTO("Matematica",9.0);
        list.add(sub1);
        StudentDTO expectedStu = new StudentDTO(190L,"Mauricio",". Felicitaciones!",9.0,list);
        when(studentDAO.findById(190L)).thenReturn(expectedStu);
        StudentDTO user = obtenerDiplomaService.analyzeScores(190L);
        assertThat(expectedStu).isEqualTo(user);
    }
}