package com.bootcamp.be_java_hisp_w16_g10_Lamela.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException() {
    }

    public ConstraintViolationException(String message) {
        super(message);
    }

}
