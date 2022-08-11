package com.bootcamp.be_java_hisp_w16_g10_Lamela.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
