package com.example.socialmeli2.exception;

public class UserAlreadyFollowingException extends RuntimeException{
    public UserAlreadyFollowingException(String msg){
        super(msg);
    }
}
