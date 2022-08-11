package com.bootcamp.be_java_hisp_w16_g08_gonzalez.exception;

import org.springframework.http.HttpStatus;

public class NotPromoPostException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public NotPromoPostException() {
        super("The user not have post whit discount");
        this.htttpStatus = HttpStatus.OK;
        this.exception = "User not have post discount";
    }
}
