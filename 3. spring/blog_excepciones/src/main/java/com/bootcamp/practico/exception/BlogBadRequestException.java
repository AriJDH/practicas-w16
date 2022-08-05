package com.bootcamp.practico.exception;

public class BlogBadRequestException extends RuntimeException{

    public BlogBadRequestException(){

    }

    public BlogBadRequestException(String message){
        super(message);
    }




}
