package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private IStudentService iStudentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void registerStudentTest() {
        StudentDTO stu = new StudentDTO();
        doNothing().when(iStudentService).create(stu);
        ResponseEntity<?> responseEntity = studentController.registerStudent(stu);
        Assertions.assertEquals(null, responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void getStudentTest() {
        StudentDTO stu = new StudentDTO();
        when(iStudentService.read(1L)).thenReturn(stu);
        StudentDTO resStudent = studentController.getStudent(1L);
        Assertions.assertEquals(resStudent, stu);
    }

    @Test
    public void modifyStudentTest() {
        StudentDTO stu = new StudentDTO();
        doNothing().when(iStudentService).update(stu);
        ResponseEntity<?> responseEntity = studentController.modifyStudent(stu);
        Assertions.assertNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void removeStudentTest() {
        doNothing().when(iStudentService).delete(1L);
        ResponseEntity<?> responseEntity = studentController.removeStudent(1L);
        Assertions.assertNull(responseEntity.getBody());
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void listStudentsTest() {
        Set<StudentDTO> students = new HashSet<>();
        students.add(new StudentDTO());
        students.add(new StudentDTO());

        when(iStudentService.getAll()).thenReturn(students);
        Set<StudentDTO> resStudent = studentController.listStudents();
        Assertions.assertEquals(resStudent, students);

    }

}
