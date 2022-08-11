package com.bootcamp.entradasblog.exception;

import com.bootcamp.entradasblog.dto.ExceptionApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler({BlogNotFoundException.class})
    public ResponseEntity<ExceptionApiDto> catchException(BlogNotFoundException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BlogRepeatedException.class})
    public ResponseEntity<ExceptionApiDto> catchException(BlogRepeatedException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Duplicate", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({NoBlogsFoundException.class})
    public ResponseEntity<ExceptionApiDto> catchException(NoBlogsFoundException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("No content", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.OK);
    }
}
