package com.example.ejerciciodosvivo.exception;

import com.example.ejerciciodosvivo.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class GlobalHandler {
    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(UserNotExistException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
