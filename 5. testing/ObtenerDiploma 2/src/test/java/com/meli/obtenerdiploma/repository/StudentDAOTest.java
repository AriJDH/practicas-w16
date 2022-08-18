package com.meli.obtenerdiploma.repository;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {
    @Autowired
    @BeforeEach
    public  void setUp(){
       studentDTO = new StudentDTO();
    }

    @Test
    void saveTest() {
        assertNull(studentDAO,"No debe arrojar result");

    }

    @Test
    void delete() {
    }

    @Test
    void exists() {
    }

    @Test
    void findById() {
    }
}