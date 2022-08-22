package com.bootcamp.SocialMeli2_gonzalez.exception;

import org.springframework.http.HttpStatus;

public class AlreadyFollowAUserException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public AlreadyFollowAUserException() {
        super("Already follow this user");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad request";
    }
}
