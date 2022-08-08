package com.bootcamp.link.exception;

import org.springframework.http.HttpStatus;

public class NotFoundLinkException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public NotFoundLinkException() {
        super("Link Not Found");
        this.htttpStatus = HttpStatus.NOT_FOUND;
        this.exception = "Link Not Found";
    }
}
