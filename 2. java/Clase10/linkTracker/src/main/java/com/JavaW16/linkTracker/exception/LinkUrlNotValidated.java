package com.JavaW16.linkTracker.exception;

public class LinkUrlNotValidated extends RuntimeException{
    public LinkUrlNotValidated ( String  query ) {
        super("La URL no correcta: " + query);
    }
}
