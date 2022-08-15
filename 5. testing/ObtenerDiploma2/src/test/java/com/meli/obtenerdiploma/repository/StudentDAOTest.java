package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentDAOTest {
  static StudentDAO studentDAO = new StudentDAO();
  static List<SubjectDTO> notas = new ArrayList<>();
  static StudentDTO student;

  @BeforeAll
  static void loadData() {
    notas.add(new SubjectDTO("Ingles", 10.0));
    student = new StudentDTO(3L, "Kevin Molano", "", 0.0, notas);
  }

  @Test
  void saveStudentTest() {
    studentDAO.save(student);
    assertEquals(student, studentDAO.findById(3L));
  }

  @Test
  void saveStudentNullTest(){
    assertThrows(NullPointerException.class, () -> studentDAO.save(null));
  }

  @Test
  void findStudentByIdTest(){
    assertEquals(1L, studentDAO.findById(1L).getId());
  }

  @Test
  void findStudentByIdNullTest(){
    assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(null));
  }

  @Test
  void modifyStudentTest(){
    studentDAO.findById(1L).setStudentName("Kevin Molano");
    assertEquals("Kevin Molano", studentDAO.findById(1L).getStudentName());
  }

  @Test
  void deleteStudentTest(){
    studentDAO.save(student);
    studentDAO.delete(3L);
    assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(3L));
  }
}