package com.javaw16.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateBlogException.class)
    public ResponseEntity<RespuestaApiDto> catchException(BlogDuplicadoException e) {
        RespuestaApiDto exceptionApiDTO = new RespuestaApiDto("Blog ya existe", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
