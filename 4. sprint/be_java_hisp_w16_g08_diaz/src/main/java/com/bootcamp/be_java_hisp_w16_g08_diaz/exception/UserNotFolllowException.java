package com.bootcamp.be_java_hisp_w16_g08_diaz.exception;

import org.springframework.http.HttpStatus;

public class UserNotFolllowException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public UserNotFolllowException(String userId, String idToUnfollow) {
        super("The user with id: " + userId + " not follow the user with the id: " + idToUnfollow);
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad Request";
    }
}
