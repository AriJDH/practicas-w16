package com.example.ejercicio2.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;

public class BlogExceptionNotFound extends RuntimeException{

    public BlogExceptionNotFound ( Integer query ) {
        super("No hay blogs con el id: " + query);
    }

}
