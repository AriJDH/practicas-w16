package com.bootcamp.link.exception;

import org.springframework.http.HttpStatus;

public class DisabledLinkException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public DisabledLinkException() {
        super("Disabled Link");
        this.htttpStatus = HttpStatus.FORBIDDEN;
        this.exception = "Disabled Link";
    }
}
