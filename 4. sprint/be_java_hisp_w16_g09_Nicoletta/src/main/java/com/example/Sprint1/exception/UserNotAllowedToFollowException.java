package com.example.Sprint1.exception;

public class UserNotAllowedToFollowException extends RuntimeException{
    public UserNotAllowedToFollowException(int id) {
        super(String.format("User with id: %d can't self follow",id));
    }
}
