package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BlogEntryNotFoundException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(BlogEntryNotFoundException e) {
        return new ResponseEntity<>(new ExceptionApiDTO("Not Found", e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BlogEntryBadRequestException.class)
    public ResponseEntity<ExceptionApiDTO> catchException(BlogEntryBadRequestException e) {
        return new ResponseEntity<>(new ExceptionApiDTO("Bad Request", e.getMessage()), HttpStatus.BAD_REQUEST);
    }
}
