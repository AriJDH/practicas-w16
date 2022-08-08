package com.ndemaio.linktrackerexercise.exception;

public class LinkUnauthorizedException extends Exception {
    public LinkUnauthorizedException(String anErrorMessage) {
        super(anErrorMessage);
    }
}
