package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class StudentRepositoryTest {
    StudentService studentService = new StudentService();
    StudentRepository studentRepository = new StudentRepository();

    @Test
    public void testListStudents() {
        var students = studentRepository.findAll();
        assertNotNull(students);
    }

}
