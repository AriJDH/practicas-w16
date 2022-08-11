package com.example.Sprint1.exception;

public class UserNotFollowing extends RuntimeException{
    public UserNotFollowing(int id, int id2) {
        super(String.format("User with id: %d not follow user with id: %d",id,id2));
    }
}
