package com.bootcamp.be_java_hisp_w16_g10.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException() {
    }

    public ConstraintViolationException(String message) {
        super(message);
    }

}
