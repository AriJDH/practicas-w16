package com.example.be_java_hisp_w16_g09_Nicoletta.exception;

public class UserDoesNotFollowedAnyone extends RuntimeException{

    public UserDoesNotFollowedAnyone(int id) {
        super(String.format("User with id: %d does not followed anyone",id));
    }
}

