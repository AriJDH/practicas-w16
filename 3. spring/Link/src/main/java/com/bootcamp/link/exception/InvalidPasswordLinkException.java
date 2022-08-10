package com.bootcamp.link.exception;

public class InvalidPasswordLinkException extends RuntimeException{
    public InvalidPasswordLinkException() {
    }

    public InvalidPasswordLinkException(String message) {
        super(message);
    }
}
