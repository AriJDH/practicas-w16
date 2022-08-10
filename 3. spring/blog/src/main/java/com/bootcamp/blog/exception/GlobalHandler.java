package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> catchBlogIdExist(BlogIdExistException exception){
        ExceptionDTO response = new ExceptionDTO(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> catchBlogIdNotExist(BlogIdNotExistException exception){
        ExceptionDTO response = new ExceptionDTO(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<ExceptionDTO> catchBlogHasNotEntries(BlogHasNotEntriesException exception){
        ExceptionDTO response = new ExceptionDTO(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
