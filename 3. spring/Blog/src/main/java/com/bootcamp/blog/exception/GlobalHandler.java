package com.bootcamp.blog.exception;

import com.bootcamp.blog.dto.ExceptionApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler({BlogAlreadyExistException.class})
    public ResponseEntity<ExceptionApiDto> catchException(BlogAlreadyExistException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Already exist", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.IM_USED);
    }
    @ExceptionHandler({BlogNotFoundException.class})
    public ResponseEntity<ExceptionApiDto> catchException(BlogNotFoundException e){
        ExceptionApiDto exceptionApiDTO = new ExceptionApiDto("Blog not found", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
