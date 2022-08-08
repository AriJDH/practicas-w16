package com.mercadolibre.bootcamp.exceptions;

public class PasswordMissmatchException extends RuntimeException {
    public PasswordMissmatchException(String id) {
        super("Password used to acccess url id: "+id+" is not valid");
    }
}
