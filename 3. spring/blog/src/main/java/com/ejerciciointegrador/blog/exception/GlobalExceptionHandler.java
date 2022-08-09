package com.ejerciciointegrador.blog.exception;

import com.ejerciciointegrador.blog.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionApiDTO> notFoundException(NotFoundException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO(e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(exceptionApiDTO, exceptionApiDTO.getStatus());
    }
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionApiDTO> badRequestException(BadRequestException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO(e.getMessage(), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(exceptionApiDTO, exceptionApiDTO.getStatus());
    }
}
