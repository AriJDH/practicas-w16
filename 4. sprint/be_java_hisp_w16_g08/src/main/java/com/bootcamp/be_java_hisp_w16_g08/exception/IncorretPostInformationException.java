package com.bootcamp.be_java_hisp_w16_g08.exception;

import org.springframework.http.HttpStatus;

public class IncorretPostInformationException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public IncorretPostInformationException() {
        super("Incorrect post information");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad request";
    }

}
