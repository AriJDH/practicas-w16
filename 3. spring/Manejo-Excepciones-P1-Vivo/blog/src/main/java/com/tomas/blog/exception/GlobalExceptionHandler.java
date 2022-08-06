package com.tomas.blog.exception;

import com.tomas.blog.dto.ExceptionBlogDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BlogFoundException.class)
    public ResponseEntity<ExceptionBlogDTO> excepcionEncontrado(BlogFoundException e){
        ExceptionBlogDTO exceptionBlogDTO = new ExceptionBlogDTO("Existe", e.getMessage());
        return new ResponseEntity<>(exceptionBlogDTO, HttpStatus.FOUND);

    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ExceptionBlogDTO> excepcionNoEncontrado(BlogNotFoundException e){
        ExceptionBlogDTO exceptionBlogDTO = new ExceptionBlogDTO("Desconocido", e.getMessage());
        return new ResponseEntity<>(exceptionBlogDTO, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(BlogEmptyException.class)
    public ResponseEntity<ExceptionBlogDTO> blogVacio(BlogEmptyException e){
        ExceptionBlogDTO exceptionBlogDTO = new ExceptionBlogDTO("Sin blogs", e.getMessage());
        return new ResponseEntity<>(exceptionBlogDTO, HttpStatus.NOT_FOUND);
    }

}
