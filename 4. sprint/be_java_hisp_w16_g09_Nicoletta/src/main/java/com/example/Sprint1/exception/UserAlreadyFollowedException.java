package com.example.Sprint1.exception;

public class UserAlreadyFollowedException extends RuntimeException {
    public UserAlreadyFollowedException(int id) {
        super(String.format("User with id: %d already followed",id));
    }
}
