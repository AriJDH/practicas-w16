package com.bootcamp.be_java_hisp_w16_g7.exception;

public class ProductWithPromoWithPastDateException extends  RuntimeException{
    public ProductWithPromoWithPastDateException(String message) {
        super(message);
    }
}
