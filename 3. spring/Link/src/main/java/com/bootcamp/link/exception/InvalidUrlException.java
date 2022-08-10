package com.bootcamp.link.exception;

public class InvalidUrlException extends RuntimeException{

    public InvalidUrlException() {
    }

    public InvalidUrlException(String message) {
        super(message);
    }
}
