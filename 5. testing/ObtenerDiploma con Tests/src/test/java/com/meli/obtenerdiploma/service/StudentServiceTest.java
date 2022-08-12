package com.meli.obtenerdiploma.service;

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
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;
    
    @InjectMocks
    StudentService studentService;

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
    void canCreateAStudent() {
        pepeStudent.setId(1l);
        when(studentDAO.findById(Mockito.any(Long.class))).thenReturn(pepeStudent);
        studentService.create(pepeStudent);

        var createdStudent = studentService.read(pepeStudent.getId());

        Assertions.assertThat(pepeStudent).isEqualTo(createdStudent);
        Mockito.verify(studentDAO).save(pepeStudent);
    }

    @Test
    void shouldRaiseException_whenReadByNonExistentId() {
        var nonExistentId = 9999l;
        when(studentDAO.findById(nonExistentId)).thenThrow(new StudentNotFoundException(nonExistentId));

        Assertions.assertThatThrownBy(() -> studentService.read(nonExistentId))
                .isInstanceOf(StudentNotFoundException.class);
    }

    @Test
    void canDeleteStudentById() {
        var pepeId = 1l;
        pepeStudent.setId(pepeId);
        when(studentRepository.findAll()).thenReturn(new HashSet());
        studentService.create(pepeStudent);

        studentService.delete(pepeId);

        var students = studentService.getAll();

        Assertions.assertThat(students).isEmpty();
        Mockito.verify(studentDAO).delete(pepeId);
    }
}
