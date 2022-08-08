package com.tomas.trackearlink.exception;

public class PasswordException extends RuntimeException {
    public PasswordException(String id) {
        super("The password is invalid for the id " + id);
    }
}