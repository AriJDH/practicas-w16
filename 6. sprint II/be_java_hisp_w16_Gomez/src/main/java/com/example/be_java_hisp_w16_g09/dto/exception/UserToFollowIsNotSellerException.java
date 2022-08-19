package com.example.be_java_hisp_w16_g09.dto.exception;

public class UserToFollowIsNotSellerException extends RuntimeException {

    public UserToFollowIsNotSellerException(int anUserId) {
        super(String.format("User with id: %d is not seller", anUserId));
    }
}
