package com.example.socialmeli2.exception;

public class FollowerNotFoundException extends RuntimeException{
    public FollowerNotFoundException(String msg){
        super(msg);
    }
}
