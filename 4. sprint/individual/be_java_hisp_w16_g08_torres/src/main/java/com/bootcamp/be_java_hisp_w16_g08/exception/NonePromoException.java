package com.bootcamp.be_java_hisp_w16_g08.exception;

import org.springframework.http.HttpStatus;

public class NonePromoException extends RuntimeException {
    public NonePromoException(String id) {
        super("User with id: " + id + " currently has no promos");
    }
}
