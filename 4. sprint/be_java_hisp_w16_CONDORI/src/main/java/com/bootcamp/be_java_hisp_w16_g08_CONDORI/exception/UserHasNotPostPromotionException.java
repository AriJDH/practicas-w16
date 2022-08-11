package com.bootcamp.be_java_hisp_w16_g08_CONDORI.exception;

import org.springframework.http.HttpStatus;

public class UserHasNotPostPromotionException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public UserHasNotPostPromotionException(int usr) {
        super("The user " + usr + " has not promotion post" );
        this.htttpStatus = HttpStatus.NO_CONTENT;
        this.exception = "Data not found";
    }
}
