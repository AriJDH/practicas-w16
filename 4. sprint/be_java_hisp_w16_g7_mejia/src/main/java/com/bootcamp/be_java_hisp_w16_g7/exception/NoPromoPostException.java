package com.bootcamp.be_java_hisp_w16_g7.exception;

public class NoPromoPostException extends RuntimeException{

    public NoPromoPostException(int id) {
        super("Seller with id: " +id+ " has no promo posts");
    }
}
