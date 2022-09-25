package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorDTOTest {
    ErrorDTO errorDTO;
    @Test
    void getName() {
        // arrange
        ErrorDTO errorDTO1 = new ErrorDTO("Error1","Error generado para tests");

        // act
        String name = errorDTO1.getName();

        // assert
        Assertions.assertEquals(name,"Error1");

    }
}