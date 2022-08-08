package com.bootcamp.links.exception;

public class NotValidException extends RuntimeException{

    public NotValidException(){
        super("El link no está habilitado");
    }
}
