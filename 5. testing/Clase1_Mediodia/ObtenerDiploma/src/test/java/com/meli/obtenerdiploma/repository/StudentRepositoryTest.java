package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    StudentRepository studentRepository;

    @BeforeEach
    void cargarRepo() {
        studentRepository = new StudentRepository();
    }

    @Test
    void cargarDatosTest() {
        assertNotNull(studentRepository.findAll());
    }
}