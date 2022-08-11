package com.bootcamp.linktracer.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(int id) {
        super("Link with id " + id + "does not exist or was disabled");
    }
}
