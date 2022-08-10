package com.bootcamp.link.exception;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException() {
    }

    public LinkNotFoundException(String message) {
        super(message);
    }
}
