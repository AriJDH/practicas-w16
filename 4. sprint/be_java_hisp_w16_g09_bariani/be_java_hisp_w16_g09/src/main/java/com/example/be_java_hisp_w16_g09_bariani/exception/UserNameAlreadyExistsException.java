package com.example.be_java_hisp_w16_g09_bariani.exception;

public class UserNameAlreadyExistsException extends RuntimeException {

    public UserNameAlreadyExistsException(String username) {
        super(String.format("User with name: %s already exists", username));
    }
}
