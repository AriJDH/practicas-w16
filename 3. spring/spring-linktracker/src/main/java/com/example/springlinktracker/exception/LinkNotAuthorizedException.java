package com.example.springlinktracker.exception;

public class LinkNotAuthorizedException extends RuntimeException {
    public LinkNotAuthorizedException(String message) {
        super(message);
    }
}
