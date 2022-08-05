package com.blog.api.exceptions;

import com.blog.api.dto.BlogDTO;
import com.blog.api.dto.BlogDtoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BlogExisteException.class)
    public ResponseEntity<BlogDtoException> catchExceptionBlogExiste(BlogExisteException e){

        BlogDtoException b = new BlogDtoException("Error", e.getMessage());

        return new ResponseEntity<>(b, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<BlogDtoException> catchExceptionNotFound(BlogNotFoundException e){

        BlogDtoException b = new BlogDtoException("Error ", e.getMessage());

        return new ResponseEntity<>(b, HttpStatus.NOT_FOUND);
    }


}
