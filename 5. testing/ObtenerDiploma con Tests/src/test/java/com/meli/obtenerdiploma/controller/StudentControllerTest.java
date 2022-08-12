package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.IStudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private List<SubjectDTO> pepeSubjects;
    private StudentDTO pepeStudent;

    @BeforeEach
    void setUp() {
        pepeSubjects = List.of(
                new SubjectDTO("Matematicas", 1d)
        );
        pepeStudent = new StudentDTO(null, "Pepe", null, null, pepeSubjects);

    }

    @Test
    void canRegisterAnStudent() {
        var response = studentController.registerStudent(pepeStudent);

        assertThat(response.getBody()).isEqualTo(null);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void cannotFetchStudentWithInexistentId() {
        var inexistentId = 9999l;
        Mockito.when(studentService.read(inexistentId))
                        .thenThrow(new StudentNotFoundException(inexistentId));

        Assertions.assertThatThrownBy(() -> studentController.getStudent(inexistentId))
                .isInstanceOf(StudentNotFoundException.class);
    }

    @Test
    void canUpdateAnStudent() {
        var response = studentController.modifyStudent(pepeStudent);

        Mockito.verify(studentService, Mockito.atMostOnce()).update(pepeStudent);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(null);
    }

    @Test
    void canDeleteAnStudent() {
        var response = studentController.removeStudent(pepeStudent.getId());

        Mockito.verify(studentService, Mockito.atMostOnce()).delete(pepeStudent.getId());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isEqualTo(null);
    }

    @Test
    void canFetchAllRegisteredStudents() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(pepeStudent);
        Mockito.when(studentService.getAll()).thenReturn(students);

        var response = studentController.listStudents();

        Mockito.verify(studentService, Mockito.atMostOnce()).getAll();
        assertThat(response.contains(pepeStudent)).isTrue();
    }


}
