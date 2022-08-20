package com.example.socialmeli.exception;

public class UserAlreadyFollowingException extends RuntimeException{
    public UserAlreadyFollowingException(String msg){
        super(msg);
    }
}
