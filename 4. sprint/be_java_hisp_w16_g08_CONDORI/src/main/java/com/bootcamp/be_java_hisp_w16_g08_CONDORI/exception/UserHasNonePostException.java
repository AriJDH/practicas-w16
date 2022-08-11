package com.bootcamp.be_java_hisp_w16_g08_CONDORI.exception;

import org.springframework.http.HttpStatus;

public class UserHasNonePostException extends RuntimeException{
    private final HttpStatus htttpStatus;
    private final String exception;

    public UserHasNonePostException(int usr) {
        super("The user " + usr + " has not none post" );
        this.htttpStatus = HttpStatus.NO_CONTENT;
        this.exception = "Data not found";
    }
}
