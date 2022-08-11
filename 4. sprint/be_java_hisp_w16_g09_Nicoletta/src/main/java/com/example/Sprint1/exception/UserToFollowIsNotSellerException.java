package com.example.Sprint1.exception;

public class UserToFollowIsNotSellerException extends RuntimeException {

    public UserToFollowIsNotSellerException(int anUserId) {
        super(String.format("User with id: %d is not seller", anUserId));
    }
}
