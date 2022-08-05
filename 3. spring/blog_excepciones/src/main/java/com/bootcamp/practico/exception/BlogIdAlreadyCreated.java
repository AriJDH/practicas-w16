package com.bootcamp.practico.exception;

public class BlogIdAlreadyCreated extends RuntimeException{

    public BlogIdAlreadyCreated(String message){
        super(message);
    }
}
