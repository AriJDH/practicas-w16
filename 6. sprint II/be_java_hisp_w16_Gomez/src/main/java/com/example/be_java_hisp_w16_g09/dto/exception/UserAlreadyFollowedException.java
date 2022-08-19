package com.example.be_java_hisp_w16_g09.dto.exception;

public class UserAlreadyFollowedException extends RuntimeException {
    public UserAlreadyFollowedException(int id) {
        super(String.format("User with id: %d already followed",id));
    }
}
