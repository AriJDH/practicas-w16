package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.util.List;

public class StudentDAOTest {

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
    void shouldSaveAStudent() {
        //Arrange
        studentDAO.save(pepeStudent);

        //Assert
        Assertions.assertThat(studentDAO.exists(pepeStudent)).isTrue();
    }

    @Test
    void shouldReturnAnStudentDTO_whenFindByExistentId() {
        studentDAO.save(pepeStudent);

        StudentDTO obtainedStudent = studentDAO.findById(pepeStudent.getId());

        Assertions.assertThat(obtainedStudent.getStudentName()).isEqualTo(pepeStudent.getStudentName());
    }

    @Test
    void shouldRaiseException_whenFindStudentWithNonExistentId() {
        long inexistentId = 999999L;

        Assertions.assertThatThrownBy(() -> studentDAO.findById(inexistentId))
                .isInstanceOf(StudentNotFoundException.class);
    }

    @Test
    void shouldUpdateAnStudent_whenSaveTwiceSameStudentDTO() {
        studentDAO.save(pepeStudent);

        //Arrange
        pepeStudent.setStudentName("PepeNew");
        studentDAO.save(pepeStudent);

        StudentDTO updatedStudent = studentDAO.findById(pepeStudent.getId());

        //Assert
        Assertions.assertThat(updatedStudent.getStudentName()).isEqualTo(pepeStudent.getStudentName());
    }

    @Test
    void shouldRemoveAnStudentById() {
        studentDAO.save(pepeStudent);

        //Arrange
        studentDAO.delete(pepeStudent.getId());

        //Assert
        Assertions.assertThat(studentDAO.exists(pepeStudent)).isFalse();
    }

}
