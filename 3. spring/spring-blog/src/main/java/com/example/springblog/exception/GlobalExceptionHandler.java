package com.example.springblog.exception;

import com.example.springblog.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {
    @ExceptionHandler(BlogEntryNotFoundException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(BlogEntryNotFoundException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IdBlogEntryAlreadyExistsException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(IdBlogEntryAlreadyExistsException e) {
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Already Exists", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }
}
