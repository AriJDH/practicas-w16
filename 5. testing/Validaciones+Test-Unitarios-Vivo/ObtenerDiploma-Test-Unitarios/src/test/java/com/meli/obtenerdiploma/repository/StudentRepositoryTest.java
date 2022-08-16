package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTest {

    @Test
    public void getAllStudentTest(){

        int amountStudent = 2;

        StudentRepository studentRepository = new StudentRepository();
        int responseCount = studentRepository.findAll().size();

        assertEquals(amountStudent, responseCount);

    }

}
