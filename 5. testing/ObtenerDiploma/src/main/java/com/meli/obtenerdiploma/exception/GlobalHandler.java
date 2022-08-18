package com.meli.obtenerdiploma.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler{

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ExceptionResponseBody> handleValidationExceptions(MethodArgumentNotValidException ex) {

        return new ResponseEntity<>(new ExceptionResponseBody(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ExceptionResponseBody> handleValidationExceptions(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ExceptionResponseBody(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }
}