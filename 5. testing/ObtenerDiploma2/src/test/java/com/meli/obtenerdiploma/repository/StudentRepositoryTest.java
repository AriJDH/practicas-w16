package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
  static IStudentRepository iStudentRepository = new StudentRepository();

  @Test
  void getAllStudentsTest(){
    assertEquals(2, iStudentRepository.findAll().size());
  }
}