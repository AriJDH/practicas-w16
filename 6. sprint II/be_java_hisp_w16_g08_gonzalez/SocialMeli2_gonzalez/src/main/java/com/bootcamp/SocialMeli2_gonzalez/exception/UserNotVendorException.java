package com.bootcamp.SocialMeli2_gonzalez.exception;

import org.springframework.http.HttpStatus;

public class UserNotVendorException extends RuntimeException{

    private final HttpStatus htttpStatus;
    private final String exception;

    public UserNotVendorException() {
        super("User not vendor");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad request";
    }
}
