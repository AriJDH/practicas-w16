package com.bootcamp.be_java_hisp_w16_g10_Lamela.exception;

public class NotFoundException extends RuntimeException{

    public NotFoundException (){}

    public NotFoundException(String message){
        super(message);
    }
}
