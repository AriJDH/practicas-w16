package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.controller.StudentController;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class Ejercicio5 {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    private StudentDTO mockedStudent;

    @BeforeEach
    void setUp() {
        List<SubjectDTO> listOfSubjects = new ArrayList<>();
        listOfSubjects.add(new SubjectDTO("Literatura", 10.0));
        mockedStudent = new StudentDTO(null, "Ricardito", null, null, listOfSubjects);

    }

    @Test
    void registerNewSAtudent() {
        var response = studentController.registerStudent(mockedStudent);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Mockito.verify(studentService,Mockito.times(1)).create(mockedStudent);
    }


    @Test
    void updateStudent() {
        var response = studentController.modifyStudent(mockedStudent);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Mockito.verify(studentService, Mockito.times(1)).update(mockedStudent);
    }

    @Test
    void canDeleteAnStudent() {
        var response = studentController.removeStudent(mockedStudent.getId());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Mockito.verify(studentService, Mockito.times(1)).delete(mockedStudent.getId());
    }

    @Test
    void canFetchAllRegisteredStudents() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(mockedStudent);
        Mockito.when(studentService.getAll()).thenReturn(students);

        var response = studentController.listStudents();

        assertThat(response.contains(mockedStudent)).isTrue();
        Mockito.verify(studentService, Mockito.times(1)).getAll();
    }
}
