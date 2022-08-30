package com.bootcamp.be_java_hisp_w16_g04.exception;

import org.springframework.http.HttpStatus;

public class FailedToCreateResource extends RuntimeException {

    private final HttpStatus htttpStatus;
    private final String exception;

    public FailedToCreateResource(String message) {
        super(message);
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = message;
    }

}
