package com.blog.blog.exception;

import com.blog.blog.dto.ExceptionApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BlogAlreadyExistsException.class)
    public ResponseEntity<ExceptionApiDto> catchException(BlogAlreadyExistsException e){
        ExceptionApiDto exceptionApiDto = new ExceptionApiDto("The Id Already Exists", e.getMessage());
        return new ResponseEntity<>(exceptionApiDto, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ExceptionApiDto> catchExceptionNotFound(BlogNotFoundException e){
        ExceptionApiDto exceptionApiDto = new ExceptionApiDto("This Id wasn't found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDto, HttpStatus.NOT_FOUND);
    }
}
