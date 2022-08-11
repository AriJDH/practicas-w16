package com.example.be_java_hisp_w16_g09.exception;

public class NotSellerException extends RuntimeException {

    public NotSellerException(int userId) {
        super(String.format("User with id: %d is not seller", userId));
    }
}
