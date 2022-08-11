package com.bootcamp.be_java_hisp_w16_g08_CONDORI.exception;

import org.springframework.http.HttpStatus;

public class PostPromotionWithoutDiscount extends  RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public PostPromotionWithoutDiscount() {
        super("The promotion has value not expected");
        this.htttpStatus = HttpStatus.BAD_REQUEST;
        this.exception = "Bad Request";
    }
}
