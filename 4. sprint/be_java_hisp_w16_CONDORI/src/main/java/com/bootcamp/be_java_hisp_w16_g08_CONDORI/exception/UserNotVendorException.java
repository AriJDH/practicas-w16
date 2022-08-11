package com.bootcamp.be_java_hisp_w16_g08_CONDORI.exception;

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
