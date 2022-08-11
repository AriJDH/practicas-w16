package com.bootcamp.be_java_hisp_w16_g08_negreyra.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistsException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public UserAlreadyExistsException() {
        super("User id already in use");
        this.htttpStatus = HttpStatus.FORBIDDEN;
        this.exception = "Forbidden";
    }
}
