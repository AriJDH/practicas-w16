package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTests {

    @Mock
    IStudentDAO iStudentDAO;

    @Mock
    IStudentRepository iStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    public void createStudent() {
        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        studentService.create(studentDTO);

        verify(iStudentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void readStudent() {

        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        when(iStudentDAO.findById(studentDTO.getId())).thenReturn(studentDTO);

        StudentDTO student = studentService.read(studentDTO.getId());

        // assert
        verify(iStudentDAO, atLeastOnce()).findById(studentDTO.getId());
        assertEquals("Lucía", student.getStudentName());
    }

    @Test
    public void updateStudent() {
        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        studentService.update(studentDTO);

        verify(iStudentDAO, atLeastOnce()).save(studentDTO);
    }

    @Test
    public void deleteStudent() {
        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        studentService.delete(studentDTO.getId());

        verify(iStudentDAO, atLeastOnce()).delete(studentDTO.getId());
    }

    @Test
    public void getAllStudents() {

        SubjectDTO subject1 = new SubjectDTO("Español", 9.0);
        SubjectDTO subject2 = new SubjectDTO("Química", 10.0);

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);

        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(10L);
        studentDTO.setStudentName("Lucía");
        studentDTO.setSubjects(subjects);

        Set<StudentDTO> students = studentService.getAll();

        // assert
        verify(iStudentRepository, atLeastOnce()).findAll();
        assertNotNull(students);
    }

}
