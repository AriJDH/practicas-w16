package com.bootcamp.be_java_hisp_w16_g10.exception;

public class UrlNotValidException extends RuntimeException{
    public UrlNotValidException() {
    }

    public UrlNotValidException(String message) {
        super(message);
    }
}
