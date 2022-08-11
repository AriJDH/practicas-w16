package com.example.be_java_hisp_w16_g09_Nicoletta.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException (int id){
        super(String.format("User with id: %d not found",id));
    }
}
