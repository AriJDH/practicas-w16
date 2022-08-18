package com.example.sports.exception;

public class ConstraintViolationException extends RuntimeException{
    public ConstraintViolationException() {
    }

    public ConstraintViolationException(String message) {
        super(message);
    }

}
