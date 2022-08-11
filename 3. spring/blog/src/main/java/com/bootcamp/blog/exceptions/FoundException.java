package com.bootcamp.blog.exceptions;

public class FoundException extends RuntimeException{
    public FoundException() {
    }

    public FoundException(String message) {
        super(message);
    }
}
