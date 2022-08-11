package com.bootcamp.linktracer.exception;

public class IncorrectPasswordException extends RuntimeException {
    public IncorrectPasswordException(int id) {
        super("Not authorized to access link with id " + id);
    }
}
