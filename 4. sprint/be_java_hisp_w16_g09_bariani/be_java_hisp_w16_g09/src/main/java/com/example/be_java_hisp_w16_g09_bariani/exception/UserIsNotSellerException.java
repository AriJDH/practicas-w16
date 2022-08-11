package com.example.be_java_hisp_w16_g09_bariani.exception;

public class UserIsNotSellerException extends RuntimeException {

    public UserIsNotSellerException(int anUserId) {
        super(String.format("User with id: %d is not seller", anUserId));
    }
}
