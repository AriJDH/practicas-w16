package com.example.be_java_hisp_w16_g03.exception;

public class InvalidOrderException extends RuntimeException {
    public InvalidOrderException(String order) {
        super(order);
    }
}
