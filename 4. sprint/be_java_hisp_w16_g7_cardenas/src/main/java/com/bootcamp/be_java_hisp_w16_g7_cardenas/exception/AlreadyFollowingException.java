package com.bootcamp.be_java_hisp_w16_g7_cardenas.exception;

public class AlreadyFollowingException extends RuntimeException {

    public AlreadyFollowingException(int userIdToFollow, int userId) {
        super("User with id " + userId + " already following user with id " + userIdToFollow);
    }
}
