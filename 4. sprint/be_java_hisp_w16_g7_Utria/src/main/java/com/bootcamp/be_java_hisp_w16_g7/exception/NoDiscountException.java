package com.bootcamp.be_java_hisp_w16_g7.exception;

public class NoDiscountException extends RuntimeException {

    public NoDiscountException() {
        super("Invalid discount. ");
    }
}
