package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO mockStudentDao;
    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    public void analyzeScoresTest() {
        StudentDTO studentDTO = Util.getNewStudentDTO("Gonzalo", Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.5),
                new SubjectDTO("Lengua", 7.0),
                new SubjectDTO("Historia", 9.0),
                new SubjectDTO("Geografia", 8.5)
        ));
        Mockito.when(this.mockStudentDao.findById(1l)).thenReturn(studentDTO);

        StudentDTO studentDTOResult = this.obtenerDiplomaService.analyzeScores(1l);

        Assertions.assertEquals(8.2, studentDTOResult.getAverageScore());
        Assertions.assertEquals("El alumno Gonzalo ha obtenido un promedio de 8.2. Puedes mejorar.", studentDTOResult.getMessage());
    }
}
