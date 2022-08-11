package com.bootcamp.be_java_hisp_w16_g01_Morales.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
