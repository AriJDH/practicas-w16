package com.example.be_java_hisp_w16_g09_bariani.exception;

public class UserNotAllowedToFollowException extends RuntimeException{
    public UserNotAllowedToFollowException(int id) {
        super(String.format("User with id: %d can't self follow",id));
    }
}
