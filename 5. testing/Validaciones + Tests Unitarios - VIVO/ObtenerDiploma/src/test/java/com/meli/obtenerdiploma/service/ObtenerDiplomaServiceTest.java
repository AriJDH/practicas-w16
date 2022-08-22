package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    void getGreetingMessageTest(){

        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemáticas", 9.0));
        list.add(new SubjectDTO("Física", 8.0));


        StudentDTO students = new StudentDTO(1l, "emanuel", "message", 1D, list);

        when(studentDAO.findById(1l)).thenReturn(students);

        StudentDTO student=obtenerDiplomaService.analyzeScores(1l);

        assertEquals(8.5,student.getAverageScore());


    }
}
