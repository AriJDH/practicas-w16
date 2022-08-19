package com.example.be_java_hisp_w16_g09.dto.exception;

public class UserHasNoFollowersException extends RuntimeException{
    public UserHasNoFollowersException(int id) {
        super(String.format("User with id: %d has no followers",id));
    }
}
