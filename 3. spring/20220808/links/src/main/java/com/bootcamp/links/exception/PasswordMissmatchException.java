package com.bootcamp.links.exception;

public class PasswordMissmatchException extends RuntimeException{

    public PasswordMissmatchException(){
        super("La password es incorrecta");
    }
}
