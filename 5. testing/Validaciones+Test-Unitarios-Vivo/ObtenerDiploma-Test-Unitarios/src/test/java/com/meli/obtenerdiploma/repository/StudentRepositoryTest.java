package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class StudentRepositoryTest {

    @Test
    public void getAllStudentTest(){

        int amountStudent = 2;

        StudentRepository studentRepository = new StudentRepository();
        int responseCount = studentRepository.findAll().size();

        assertEquals(amountStudent, responseCount);

    }

}
