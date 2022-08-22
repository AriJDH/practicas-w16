package com.meli.be_java_hisp_w16_g5.exceptions;

/**
 * Excepcion para User
 */
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message) {
        super(message);
    }
}
