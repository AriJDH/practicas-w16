package com.bootcamp.be_java_hisp_w16_g10.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
