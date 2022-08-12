package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class StudentRepositoryTest {

    private StudentDAO studentDAO;
    private StudentDTO pepeStudent;
    private List<SubjectDTO> pepeSubjects;

    @BeforeEach
    void setUp() {
        studentDAO = new StudentDAO();

        pepeSubjects = List.of(
                new SubjectDTO("Matematicas", 1d)
        );
        pepeStudent = new StudentDTO(null, "Pepe", null, null, pepeSubjects);

    }

    @Test
    void shouldReturnEmptySet_whenDoesNotExistRegisteredStudents() {
        StudentRepository studentRepository = new StudentRepository();

        Set<StudentDTO> savedStudents = studentRepository.findAll();

        Assertions.assertThat(savedStudents.isEmpty()).isTrue();
    }

}
