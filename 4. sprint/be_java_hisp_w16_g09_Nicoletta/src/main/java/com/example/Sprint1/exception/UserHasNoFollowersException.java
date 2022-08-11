package com.example.Sprint1.exception;

public class UserHasNoFollowersException extends RuntimeException{
    public UserHasNoFollowersException(int id) {
        super(String.format("User with id: %d has no followers",id));
    }
}
