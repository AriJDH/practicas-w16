package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class Ejercicio1 {

    private StudentDAO studentDAO;
    private StudentRepository studentRepository;


    @BeforeEach
    void setup() {
        studentDAO = new StudentDAO();
        studentRepository = new StudentRepository();
        studentDAO.setStudents(new HashSet<>());
    }

    @Test
    void saveNewStudentToDAO() {
        StudentDTO student = new StudentDTO(Long.getLong("1"), "Javier", "Mensaje random", 6.0, new ArrayList<>());
        studentDAO.save(student);
        assertTrue(studentDAO.exists(student));
    }

    @Test
    void deleteStudentFromDAO() {
        StudentDTO student = new StudentDTO(1L, "Javier2", "Mensaje random", 6.0, new ArrayList<>());

        studentDAO.save(student);
        boolean isDeleted = studentDAO.delete(1L);

        assertTrue(isDeleted);
    }

    @Test
    void deleteStudentNotCreatedFromDAO() {
        boolean isDeleted = studentDAO.delete(100L);
        assertFalse(isDeleted);
    }

    @Test
    void SearchStudentById() {
        StudentDTO student = new StudentDTO(1L, "Javier3", "Mensaje random", 6.0, new ArrayList<>());

        studentDAO.save(student);

        assertEquals(1L, studentDAO.findById(1L).getId());
    }

    @Test
    void repositoryHasData() {
        assertNotNull(studentRepository.findAll());
    }

}
