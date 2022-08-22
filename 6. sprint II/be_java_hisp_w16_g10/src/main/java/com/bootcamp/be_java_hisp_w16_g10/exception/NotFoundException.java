package com.bootcamp.be_java_hisp_w16_g10.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException (){}

    public NotFoundException(String message){
        super(message);
    }
}
