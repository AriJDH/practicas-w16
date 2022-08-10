package com.example.be_java_hisp_w16_g09_bariani.exception;

public class UserNotFollowing extends RuntimeException{
    public UserNotFollowing(int id, int id2) {
        super(String.format("User with id: %d not follow user with id: %d",id,id2));
    }
}
