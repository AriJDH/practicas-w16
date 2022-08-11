package com.bootcamp.be_java_hisp_w16_g10_Lamela.exception;

public class UrlNotValidException extends RuntimeException{
    public UrlNotValidException() {
    }

    public UrlNotValidException(String message) {
        super(message);
    }
}
