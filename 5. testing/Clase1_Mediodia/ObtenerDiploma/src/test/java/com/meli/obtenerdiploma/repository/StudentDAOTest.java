package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    StudentDAO repository;
    StudentDTO nuevo3,nuevo2;

    @BeforeEach
    void cargarRepo() {
        repository = new StudentDAO();
        nuevo2 = new StudentDTO(180L,"",null,null,null);
        nuevo3 = new StudentDTO(190L,"",null,null,null);
        repository.save(nuevo3);
    }

    @Test
    void save() {
        repository.save(nuevo2);
        //Assert
        assertTrue(repository.exists(nuevo2));
    }

    @Test
    void delete() {
        repository.delete(180L);
        //Assert
        assertFalse(repository.exists(nuevo2));
    }

    @Test
    void exists() {
        assertTrue(repository.exists(nuevo3));
    }

    @Test
    void findById() {
        assertNotEquals(null, repository.findById(8L));
    }

    @Test
    void findByIdNoExistente() {
        //Act
        assertThrows(StudentNotFoundException.class, () -> repository.findById(198L));
    }

}