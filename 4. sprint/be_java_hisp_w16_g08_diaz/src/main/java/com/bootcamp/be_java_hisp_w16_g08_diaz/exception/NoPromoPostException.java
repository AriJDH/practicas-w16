package com.bootcamp.be_java_hisp_w16_g08_diaz.exception;

import org.springframework.http.HttpStatus;

public class NoPromoPostException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;
    public NoPromoPostException() {
        super("User without promo post");
        this.htttpStatus=HttpStatus.OK;
        this.exception="User without promo post";
    }
}
