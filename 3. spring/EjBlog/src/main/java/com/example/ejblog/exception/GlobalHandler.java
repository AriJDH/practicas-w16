package com.example.ejblog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BlogExisteException.class)
    public ResponseEntity<BlogDtoException> ExceptionBlogExiste(BlogExisteException e){

        BlogDtoException res = new BlogDtoException("Error", e.getMessage());

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<BlogDtoException> ExceptionBlogExiste(BlogNotFoundException e){

        BlogDtoException res = new BlogDtoException("Error", e.getMessage());

        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

}
