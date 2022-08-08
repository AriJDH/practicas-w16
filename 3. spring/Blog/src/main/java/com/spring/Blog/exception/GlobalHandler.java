package com.spring.Blog.exception;

import com.spring.Blog.dto.ExceptionApiDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler({BlogRepeatedException.class})
    public ResponseEntity<ExceptionApiDTO> catchException(BlogRepeatedException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Duplicate", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({BlogNotFoundException.class})
    public ResponseEntity<ExceptionApiDTO> catchException(BlogNotFoundException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found",e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NoBlogsFoundException.class})
    public ResponseEntity<ExceptionApiDTO> catchException(NoBlogsFoundException e){
        ExceptionApiDTO exceptionApiDTO = new ExceptionApiDTO("Not Found",e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

}
