package com.example.ejercicio2.exception;

public class BlogExceptionCreateNotFound extends RuntimeException{

    public BlogExceptionCreateNotFound ( Integer query ) {
        super("Ya tenemos un blog con el id: " + query);
    }
}
