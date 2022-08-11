package com.example.Sprint1.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (int id){
        super(String.format("User with id: %d not found",id));
    }
}
