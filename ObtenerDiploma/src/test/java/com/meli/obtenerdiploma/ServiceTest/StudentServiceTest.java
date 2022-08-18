package com.meli.obtenerdiploma.ServiceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentRepository studentRepository;
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private IStudentService studentService = new StudentService();

    @Test
    public void shouldCallStudentDAOSave() {
        StudentDTO student = new StudentDTO();
        studentService.create(student);
        verify(studentDAO,times(1)).save(student);
    }
    @Test
    public void shouldCallStudentDAOUpdate() {
        StudentDTO student = new StudentDTO();
        studentService.update(student);
        verify(studentDAO,times(1)).save(student);
    }
    @Test
    public void shouldCallStudentDAODelete() {
        StudentDTO student = new StudentDTO();
        studentService.delete(1L);
        verify(studentDAO,times(1)).delete(1L);
    }
    @Test
    public void shouldCallStudentDAOFindById() {
        StudentDTO student = new StudentDTO();
        studentService.read(1L);
        verify(studentDAO,times(1)).findById(1L);
    }

    @Test
    public void GivenAnIdReadShouldReturnAnStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Matias");
        student.setMessage("hola");
        when(studentDAO.findById(1L)).thenReturn(student);
        StudentDTO studentReturned = studentService.read(1L);
        verify(studentDAO,times(1)).findById(1L);
        assertEquals(student, studentReturned);
    }
    @Test
    public void GetAllShouldReturnAListOfStudent() {
        StudentDTO student = new StudentDTO();
        student.setStudentName("Matias");
        student.setMessage("hola");
        Set<StudentDTO> students = new HashSet<>();
        students.add(student);
        when(studentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> studentsReturned = studentService.getAll();
        verify(studentRepository,times(1)).findAll();
        assertEquals(students, studentsReturned);
    }
}
