package com.bootcamp.practico.exception;

public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException(String message){
        super(message);
    }
}
