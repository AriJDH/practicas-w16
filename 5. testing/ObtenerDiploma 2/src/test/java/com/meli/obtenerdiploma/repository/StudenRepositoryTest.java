package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

public class StudenRepositoryTest {
    private StudentRepository tested = new StudentRepository();


    @Test
    public void findAll(){

        Set<StudentDTO> actual = tested.findAll();

        Assertions.assertEquals(4,actual.size());

    }
}
