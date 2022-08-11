package com.bootcamp.be_java_hisp_w16_g08_CONDORI.exception;

import org.springframework.http.HttpStatus;

public class OrderNotPossibleException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public OrderNotPossibleException() {
        super("That sorting order is not valid");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad Request";
    }
}
