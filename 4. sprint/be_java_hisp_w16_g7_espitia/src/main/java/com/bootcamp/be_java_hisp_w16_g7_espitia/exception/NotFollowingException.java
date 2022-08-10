package com.bootcamp.be_java_hisp_w16_g7_espitia.exception;

public class NotFollowingException extends RuntimeException {

    public NotFollowingException(int userIdToFollow, int userId) {
        super("User with id " + userId + " is not following user with id " + userIdToFollow);
    }
}
