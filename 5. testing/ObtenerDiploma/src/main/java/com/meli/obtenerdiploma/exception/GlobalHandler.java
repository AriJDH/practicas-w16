package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionApiDTO> handleValidationExceptions(MethodArgumentNotValidException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getFieldError().getDefaultMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionApiDTO> handleValidationExceptions(HttpMessageNotReadableException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Error", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

}
