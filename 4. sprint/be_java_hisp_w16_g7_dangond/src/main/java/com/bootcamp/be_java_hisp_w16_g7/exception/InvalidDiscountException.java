package com.bootcamp.be_java_hisp_w16_g7.exception;

public class InvalidDiscountException extends RuntimeException {

    public InvalidDiscountException(double discount) {
        super(discount + " is not valid");
    }
}
