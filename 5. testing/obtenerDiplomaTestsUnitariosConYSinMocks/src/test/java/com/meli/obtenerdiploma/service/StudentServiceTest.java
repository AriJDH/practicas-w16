package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private IStudentDAO iStudentDAO;
    @Mock
    private IStudentRepository iStudentRepository;
    @InjectMocks
    private StudentService studentService;

    @Test
    public void createTest() {
        StudentDTO stu = new StudentDTO();
        doNothing().when(iStudentDAO).save(stu);
        studentService.create(stu);
        verify(iStudentDAO, atLeast(1)).save(stu);
    }

    @Test
    public void readTest() {
        StudentDTO stu = new StudentDTO();
        when(iStudentDAO.findById(20L)).thenReturn(stu);
        StudentDTO student = studentService.read(20L);
        Assertions.assertEquals(student, stu);
    }

    @Test
    public void updateTest() {
        StudentDTO stu = new StudentDTO();
        doNothing().when(iStudentDAO).save(stu);
        studentService.update(stu);
        verify(iStudentDAO, atLeast(1)).save(stu);
    }

    @Test
    public void deleteReturnTrueTest() {
        StudentDTO stu = new StudentDTO();
        when(iStudentDAO.delete(1L)).thenReturn(true);
        studentService.delete(1L);
        verify(iStudentDAO, atLeast(1)).delete(1L);
    }

    @Test
    public void deleteReturnFalseTest() {
        StudentDTO stu = new StudentDTO();
        when(iStudentDAO.delete(1L)).thenReturn(false);
        studentService.delete(1L);
        verify(iStudentDAO, atLeast(1)).delete(1L);
    }

    @Test
    public void getAllTest() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO());
        students.add(new StudentDTO());
        when(iStudentRepository.findAll()).thenReturn(students);
        Set<StudentDTO> resultListStudents = studentService.getAll();
        Assertions.assertEquals(resultListStudents, students);
    }

}
