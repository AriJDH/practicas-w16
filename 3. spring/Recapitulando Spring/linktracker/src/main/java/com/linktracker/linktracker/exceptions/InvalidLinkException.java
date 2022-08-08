package com.linktracker.linktracker.exceptions;

public class InvalidLinkException extends RuntimeException{
    public InvalidLinkException(){
        
    }

    public InvalidLinkException(String message) {
        super(message);
    }
}
