package com.bootcamp.links.exception;

public class NoMatchException extends RuntimeException{

    public NoMatchException(String url){
        super("La URL: " + url + " no tiene formato válido");
    }
}
