package com.bootcamp.be_java_hisp_w16_g7_cardenas.exception;

public class UserIsNotSellerException extends RuntimeException {
    public UserIsNotSellerException(int id) {
        super("User " + id + " is not seller");
    }
}
