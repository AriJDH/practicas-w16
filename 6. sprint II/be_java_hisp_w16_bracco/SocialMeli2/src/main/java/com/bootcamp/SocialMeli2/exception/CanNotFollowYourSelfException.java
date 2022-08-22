package com.bootcamp.SocialMeli2.exception;

import org.springframework.http.HttpStatus;

public class CanNotFollowYourSelfException extends RuntimeException {

    private final HttpStatus htttpStatus;
    private final String exception;

    public CanNotFollowYourSelfException() {
        super("Can not follow yourself");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad request";
    }
}
