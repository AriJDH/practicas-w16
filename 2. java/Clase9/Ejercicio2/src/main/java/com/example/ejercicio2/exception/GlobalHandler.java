package com.example.ejercicio2.exception;

import com.example.ejercicio2.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BlogExceptionNotFound.class)
    public ResponseEntity<ExceptionApiDTO> catchException(BlogExceptionNotFound e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(BlogExceptionCreateNotFound.class)
    public ResponseEntity<ExceptionApiDTO> catchException(BlogExceptionCreateNotFound e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
