package com.linktracker.linktracker.exceptions;

public class LinkNotAuthorizatedException extends RuntimeException{
    public LinkNotAuthorizatedException(){
        
    }

    public LinkNotAuthorizatedException(String message) {
        super(message);
    }
    
}
