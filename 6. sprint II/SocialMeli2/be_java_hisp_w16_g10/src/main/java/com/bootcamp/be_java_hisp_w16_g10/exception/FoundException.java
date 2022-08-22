package com.bootcamp.be_java_hisp_w16_g10.exception;

public class FoundException extends RuntimeException{
    public FoundException() {
    }

    public FoundException(String message) {
        super(message);
    }
}
