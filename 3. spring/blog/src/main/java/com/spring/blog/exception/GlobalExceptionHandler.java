package com.spring.blog.exception;

import com.spring.blog.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(BlogAlreadyExistsException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Blog already exists", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(BlogNotFoundException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Blog not found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoBlogsFoundException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(NoBlogsFoundException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("No blogs found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

}
