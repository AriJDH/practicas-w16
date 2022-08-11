package com.bootcamp.linktracker.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException() {
    }

    public ConstraintViolationException(String message) {
        super(message);
    }

}
