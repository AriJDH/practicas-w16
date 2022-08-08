package com.example.blog.exception;

import com.example.blog.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<ResponseDTO> catchException(DuplicateIdException e) {
        ResponseDTO exceptionApiDTO = new ResponseDTO("El blog ya existe", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ResponseDTO> catchException(BlogNotFoundException e) {
        ResponseDTO exceptionApiDTO = new ResponseDTO("El blog ya no existe", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
