package com.tomas.trackearlink.exception;

public class LinkInactiveException extends RuntimeException {
    public LinkInactiveException(String id) {
        super("The url with id " + id + " is inactive");
    }
}