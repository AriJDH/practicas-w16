package com.bootcamp.be_java_hisp_w16_g7_espitia.exception;

public class InvalidQueryException extends RuntimeException {
    public InvalidQueryException() {
    }

    public InvalidQueryException(String message) {
        super(message);
    }
}


