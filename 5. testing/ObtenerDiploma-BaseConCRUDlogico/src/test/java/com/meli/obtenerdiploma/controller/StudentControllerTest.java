package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService mockStudentService;
    @InjectMocks
    private StudentController studentController;

    @Test
    public void getStudentTest() {
        StudentDTO studentDTO = Util.getNewStudentDTO(1l, "Gonzalo");
        Mockito.when(this.mockStudentService.read(1l)).thenReturn(studentDTO);

        StudentDTO studentDTOResult = this.studentController.getStudent(1l);

        Assertions.assertEquals(1, studentDTOResult.getId());
    }

    @Test
    public void getStudentInvalidTest() {
        Mockito.when(this.mockStudentService.read(100l)).thenThrow(new StudentNotFoundException(100l));

        Assertions.assertThrows(StudentNotFoundException.class, () -> this.mockStudentService.read(100l));
    }

    @Test
    public void listStudentsTest() {
        Set<StudentDTO> studentDTOSet = Set.of(
                Util.getNewStudentDTO("Juan"),
                Util.getNewStudentDTO("Pablo")
        );
        Mockito.when(this.studentController.listStudents()).thenReturn(studentDTOSet);

        Set<StudentDTO> studentDTOSetResult = this.studentController.listStudents();

        Assertions.assertEquals(2, studentDTOSetResult.size());
    }
}
