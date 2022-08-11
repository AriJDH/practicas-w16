package com.bootcamp.be_java_hisp_w16_g08.exception;

import org.springframework.http.HttpStatus;

public class NoPromoPostException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;
    public NoPromoPostException() {
        super("User without promoPost");
        this.htttpStatus=HttpStatus.BAD_REQUEST;
        this.exception="Not found";
    }
}
