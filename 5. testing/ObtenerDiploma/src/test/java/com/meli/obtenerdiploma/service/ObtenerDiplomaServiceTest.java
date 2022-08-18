package com.meli.obtenerdiploma.service;

import static org.mockito.Mockito.when;

import java.text.DecimalFormat;
import java.util.List;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

   @Mock
   IStudentDAO studentDAO;

   @InjectMocks
   ObtenerDiplomaService obtenerDiplomaService;

   private List<SubjectDTO> aleSubjets;
   private StudentDTO aleStudent;

   @BeforeEach
   void setUp() {
      aleStudent = new StudentDTO(null, "Alejandro", null, null, null);

   }

   @Test
   void shouldAnalizeScores_lowerThanNine() {

      aleStudent.setId(1L);

      aleStudent
            .setSubjects(aleSubjets = List.of(new SubjectDTO("Programacion", 1D), new SubjectDTO("Matematica", 9D)));

      when(studentDAO.findById(Mockito.anyLong())).thenReturn(aleStudent);

      obtenerDiplomaService.analyzeScores(aleStudent.getId());

      Assertions.assertThat(aleStudent.getAverageScore() < 9D).isTrue();
      Assertions.assertThat(aleStudent.getMessage()
            .equals("El alumno " + aleStudent.getStudentName() + " ha obtenido un promedio de "
                  + new DecimalFormat("#.##").format(aleStudent.getAverageScore())
                  + ((aleStudent.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar.")))
            .isTrue();

   }

   @Test
   void shouldAnalizeScores_biggerThanNine() {
      aleStudent.setId(1L);
      aleStudent.setSubjects(aleSubjets = List.of(new SubjectDTO("Programacion", 10D), new SubjectDTO("Matematica", 9D))

      );

      when(studentDAO.findById(Mockito.anyLong())).thenReturn(aleStudent);

      obtenerDiplomaService.analyzeScores(aleStudent.getId());

      Assertions.assertThat(aleStudent.getAverageScore() > 9D).isTrue();
      Assertions.assertThat(aleStudent.getMessage()
            .equals("El alumno " + aleStudent.getStudentName() + " ha obtenido un promedio de "
                  + new DecimalFormat("#.##").format(aleStudent.getAverageScore())
                  + ((aleStudent.getAverageScore() > 9) ? ". Felicitaciones!" : ". Puedes mejorar.")))
            .isTrue();

   }

   @Test
   void shouldRiseStudentNotFoundException_whenAnalizeScoreByNonExistingId(){

      when(studentDAO.findById(99999L)).thenThrow(new StudentNotFoundException(99999L));   

     Assertions.assertThatThrownBy(() -> obtenerDiplomaService.analyzeScores(99999L)).isInstanceOf(StudentNotFoundException.class);   

   }
}
