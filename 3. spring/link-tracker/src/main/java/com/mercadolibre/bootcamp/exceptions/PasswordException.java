package com.mercadolibre.bootcamp.exceptions;

public class PasswordException extends RuntimeException {
    public PasswordException(String id) {
        super("The password is invalid for the id " + id);
    }
}
