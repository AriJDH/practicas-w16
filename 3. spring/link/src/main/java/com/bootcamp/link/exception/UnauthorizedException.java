package com.bootcamp.link.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public UnauthorizedException() {
        super("Not Authorized");
        this.htttpStatus = HttpStatus.UNAUTHORIZED;
        this.exception = "Not Authorized";
    }
}
