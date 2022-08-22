package com.bootcamp.SocialMeli2.exception;

import org.springframework.http.HttpStatus;

public class UserNotFollowException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public UserNotFollowException(String userId, String idToUnfollow) {
        super("The user with id: " + userId + " not follow the user with the id: " + idToUnfollow);
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad Request";
    }
}
