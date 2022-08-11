package com.bootcamp.be_java_hisp_w16_g7_cardenas.exception;


public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id) {
        super("User with id " + id + " not found");
    }
}
