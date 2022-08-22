package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.dto.CustomExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<CustomExceptionDTO> handleValidationException(MethodArgumentNotValidException ex) {
        CustomExceptionDTO customException = new CustomExceptionDTO("Argumento no valido", ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<CustomExceptionDTO> handleValidationException(HttpMessageNotReadableException ex) {
        CustomExceptionDTO customException = new CustomExceptionDTO("No leible", ex.getMessage());
        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }
}
