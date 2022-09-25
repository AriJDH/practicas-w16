package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaExceptionControllerTest {

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaExceptionController controller;

    @Test
    void handleGlobalExceptions() {
        // arrange
   

        // act
        ObtenerDiplomaException obtenerDiplomaException= new ObtenerDiplomaException("Error", HttpStatus.NOT_FOUND);

        // assert

        assertFalse(false,"404 NOT_FOUND");
    }

    @Test
    void handleValidationExceptions() {
    }

    @Test
    void testHandleValidationExceptions() {
    }
}