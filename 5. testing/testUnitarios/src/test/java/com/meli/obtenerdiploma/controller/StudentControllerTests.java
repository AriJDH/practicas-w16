package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    @Test
    public void registerStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //Act
        controller.registerStudent(stu);
        //Assert
        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    public void getStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(stu.getId())).thenReturn(stu);
        //Act
        StudentDTO readStu = controller.getStudent(stu.getId());
        //Assert
        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void modifyStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //Act
        controller.modifyStudent(stu);
        //Assert
        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent() {
        //Arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        //Act
        controller.removeStudent(stu.getId());
        //Assert
        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void listStudents() {
        //Arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);
        //Act
        Set<StudentDTO> readStudents = controller.listStudents();
        //Assert
        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }
}
