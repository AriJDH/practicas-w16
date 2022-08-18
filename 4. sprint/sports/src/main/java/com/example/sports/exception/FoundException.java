package com.example.sports.exception;

public class FoundException extends RuntimeException{
    public FoundException() {
    }

    public FoundException(String message) {
        super(message);
    }
}
