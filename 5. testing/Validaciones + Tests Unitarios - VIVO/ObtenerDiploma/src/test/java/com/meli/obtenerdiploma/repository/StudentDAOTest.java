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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentDAOTest {
    @Autowired
    IStudentDAO studentDAO;

    @Test
    void testSave() {
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);

        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()),student);
        studentDAO.clear();
    }

    @Test
    void testUpdate() {
        SubjectDTO subject3 = new SubjectDTO("Matemàticas", 8.0);

        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);

        studentDAO.findById(student.getId());
        student.setStudentName("Erika Vanessa");
        listSubject.add(subject3);
        student.setSubjects(listSubject);

        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertEquals(1L, student.getId());
        Assertions.assertEquals(studentDAO.findById(student.getId()),student);
        studentDAO.clear();
    }

    @Test
    void testDelete() {
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        //Guardar
        studentDAO.save(student);

        //Eliminar
        studentDAO.delete(student.getId());

        Assertions.assertFalse(studentDAO.exists(student));
        studentDAO.clear();
    }

    @Test
    void testExists() {
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);
        System.out.println(studentDAO);

        Assertions.assertTrue(studentDAO.exists(student));
        studentDAO.clear();
    }

    @Test
    void testFindById() {
        List<SubjectDTO> listSubject = new ArrayList<>(Arrays.asList(Utiles.getSubject("Quìmica",9.0),
                Utiles.getSubject("Fisica",8.0)));
        StudentDTO student = Utiles.getStudent(1L, "Erika", listSubject);

        studentDAO.save(student);
        System.out.println(studentDAO);

        Assertions.assertTrue(studentDAO.exists(student));
        Assertions.assertNotNull(studentDAO.findById(student.getId()));
        Assertions.assertEquals(studentDAO.findById(student.getId()),student);
        studentDAO.clear();
    }
}