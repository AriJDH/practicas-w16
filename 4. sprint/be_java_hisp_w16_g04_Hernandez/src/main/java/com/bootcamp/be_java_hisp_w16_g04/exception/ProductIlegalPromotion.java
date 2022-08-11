package com.bootcamp.be_java_hisp_w16_g04.exception;

public class ProductIlegalPromotion extends RuntimeException{
    public ProductIlegalPromotion(String message) {
        super(message);
    }
}
