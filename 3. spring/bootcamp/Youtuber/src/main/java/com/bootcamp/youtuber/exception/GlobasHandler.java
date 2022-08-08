package com.bootcamp.youtuber.exception;

import com.bootcamp.youtuber.dto.ResponseApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobasHandler {

    @ExceptionHandler(DuplicatedBlogException.class)
    public ResponseEntity<ResponseApiDto> catchException(DuplicatedBlogException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Blog ya existe", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.ALREADY_REPORTED);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ResponseApiDto> catchNotFoundException(BlogNotFoundException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Blog no encontrado", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
