package com.meli.obtenerdiploma.repository;

import java.util.List;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentDAOTest {

   private StudentDAO studentDAO;
   private StudentDTO pepeStudent;
   private List<SubjectDTO> pepeSubjects;

   @BeforeEach
   void setup() {
      studentDAO = new StudentDAO();

      pepeSubjects = List.of(new SubjectDTO("Lengua", 2d));

      pepeStudent = new StudentDTO(null, "Pepe", null, null, pepeSubjects);
   }

   @Test
   void shouldSaveAStudent() {
      studentDAO.save(pepeStudent);

      Assertions.assertThat(studentDAO.exists(pepeStudent)).isTrue();

   }

   @Test
   void shouldDeleteAStudent() {
      studentDAO.save(pepeStudent);

      studentDAO.delete(pepeStudent.getId());

      Assertions.assertThat(studentDAO.exists(pepeStudent)).isFalse();

   }

   @Test
   void shouldUpdateAStudent_whenTheyHaveTheSameId() {

      studentDAO.save(pepeStudent);
      String oldName = pepeStudent.getStudentName();
      pepeStudent.setStudentName("Pepito");

      studentDAO.save(pepeStudent);

      Assertions.assertThat(studentDAO.findById(pepeStudent.getId()).getStudentName().equals(oldName)).isFalse();

   }

   @Test
   void shouldFindStudent() {
      studentDAO.save(pepeStudent);

      StudentDTO findedStudent = studentDAO.findById(pepeStudent.getId());

      Assertions.assertThat(findedStudent.equals(pepeStudent)).isTrue();

   }

   @Test
   void shouldRiseStudenNotFoundException_whenNonExistingId(){
      Assertions.assertThatThrownBy(()-> studentDAO.findById(9999999L)).isInstanceOf(StudentNotFoundException.class);   
   }



}
