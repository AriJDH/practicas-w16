package com.bootcamp.link.exception;


import org.springframework.http.HttpStatus;

public class InvalidLinkException extends RuntimeException {

    private final HttpStatus htttpStatus;
    private final String exception;

    public InvalidLinkException() {
        super("Invalid Link");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Invalid Link";
    }
}
