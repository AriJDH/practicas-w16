package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.Utiles;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    IStudentDAO studentDAO;
    @Autowired
    IStudentRepository studentRepository;

    @Test
    void findAll() {

        studentDAO.clear();

        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);

        Set<StudentDTO> listStudent = studentRepository.findAll();

        Assertions.assertNotNull(listStudent);
        Assertions.assertEquals(1,listStudent.size());
        studentDAO.clear();
    }
}