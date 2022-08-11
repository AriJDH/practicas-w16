package com.example.Sprint1.exception;

public class UserDoesNotFollowedAnyone extends RuntimeException{

    public UserDoesNotFollowedAnyone(int id) {
        super(String.format("User with id: %d does not followed anyone",id));
    }
}

