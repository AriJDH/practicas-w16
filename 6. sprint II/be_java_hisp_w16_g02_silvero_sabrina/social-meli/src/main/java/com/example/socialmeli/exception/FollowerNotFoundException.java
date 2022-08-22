package com.example.socialmeli.exception;

public class FollowerNotFoundException extends RuntimeException{
    public FollowerNotFoundException(String msg){
        super(msg);
    }
}
