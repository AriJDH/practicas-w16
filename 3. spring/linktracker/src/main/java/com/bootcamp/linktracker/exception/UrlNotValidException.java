package com.bootcamp.linktracker.exception;

public class UrlNotValidException extends RuntimeException{
    public UrlNotValidException() {
    }

    public UrlNotValidException(String message) {
        super(message);
    }
}
