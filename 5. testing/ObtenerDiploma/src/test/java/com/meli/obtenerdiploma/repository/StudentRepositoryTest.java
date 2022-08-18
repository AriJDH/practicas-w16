package com.meli.obtenerdiploma.repository;

import java.util.List;
import java.util.Set;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentRepositoryTest {
   private StudentDAO studentDAO;
   private List<SubjectDTO> pepeSubjects;
   private StudentDTO pepeStudent;

   @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();

        pepeSubjects = List.of(
                new SubjectDTO("Matematicas", 1d)
        );
        pepeStudent = new StudentDTO(null, "Pepe", null, null, pepeSubjects);

    }

   @Test
   void shouldReturnEmptySet_whenDoesNotExistRegistredStudent(){

      StudentRepository studentRepository = new StudentRepository();   

      Set<StudentDTO> savedStudents =  studentRepository.findAll();

      Assertions.assertThat(savedStudents.isEmpty()).isTrue();

   }
}
 
