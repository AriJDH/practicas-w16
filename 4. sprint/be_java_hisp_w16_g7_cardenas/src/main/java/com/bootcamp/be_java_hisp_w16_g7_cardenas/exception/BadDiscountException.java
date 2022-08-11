package com.bootcamp.be_java_hisp_w16_g7_cardenas.exception;

public class BadDiscountException extends RuntimeException {
    public BadDiscountException() {
        super("Post has to include a discount");
    }
}
