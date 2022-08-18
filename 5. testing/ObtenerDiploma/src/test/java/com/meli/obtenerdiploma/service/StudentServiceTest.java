package com.meli.obtenerdiploma.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

   @Mock
   IStudentDAO studentDAO;

   @Mock
   IStudentRepository studentRepository;

   @InjectMocks
   StudentService studentService;

   private List<SubjectDTO> aleSubjets;
   private StudentDTO aleStudent;

   @BeforeEach
   void setUp() {
      aleSubjets = List.of(new SubjectDTO("Programacion", 1D));
      aleStudent = new StudentDTO(null, "Alejandro", null, null, aleSubjets);
   }

   @Test
   void shoudlCreateAStuden() {

      aleStudent.setId(1L);

      doNothing().when(studentDAO).save(Mockito.any(StudentDTO.class));

      studentService.create(aleStudent);

      Mockito.verify(studentDAO).save(aleStudent);

   }

   @Test
   void shouldReadAnStudent() {

      aleStudent.setId(1L);

      when(studentDAO.findById(Mockito.anyLong())).thenReturn(aleStudent);

      Assertions.assertThat(aleStudent.equals(studentService.read(1L)));
      Mockito.verify(studentDAO).findById(1L);

   }

   @Test
   void shouldRiseStudentNotFoundExcepcion_whenReadByNonExistId() {
      when(studentDAO.findById(99999L)).thenThrow(new StudentNotFoundException(99999L));

      Assertions.assertThatThrownBy(() -> studentService.read(99999L)).isInstanceOf(StudentNotFoundException.class);
   }

   @Test
   void shouldUpdateStudent() {
      aleStudent.setId(1L);

      doNothing().when(studentDAO).save(Mockito.any(StudentDTO.class));

      studentService.update(aleStudent);

      Mockito.verify(studentDAO).save(aleStudent);

   }

   @Test
   void shouldDeleteStudent() {
      aleStudent.setId(1L);

      when(studentDAO.delete(Mockito.anyLong())).thenReturn(true);

      studentService.delete(aleStudent.getId());

      Mockito.verify(studentDAO).delete(aleStudent.getId());

   }

   @Test
   void shouldRiseStudentNotFoundException_whenTryToDeleteByNonExistId() {

      when(studentDAO.delete(99999L)).thenThrow(new StudentNotFoundException(99999L));

      Assertions.assertThatThrownBy(() -> studentService.delete(99999L)).isInstanceOf(StudentNotFoundException.class);
   }

   @Test
   void shouldBringAllStudents() {
      Set<StudentDTO> setStudentDTO = new HashSet<>();

      when(studentRepository.findAll()).thenReturn(setStudentDTO);

      studentService.getAll();

      Mockito.verify(studentRepository).findAll();

   }

}
