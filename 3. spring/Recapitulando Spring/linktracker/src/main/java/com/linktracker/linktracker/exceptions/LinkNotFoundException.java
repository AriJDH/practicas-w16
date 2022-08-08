package com.linktracker.linktracker.exceptions;

import lombok.Data;

@Data
public class LinkNotFoundException extends RuntimeException{

    private String link;

    public LinkNotFoundException(){
        
    }

    public LinkNotFoundException(String message) {
        super(message);
    }
}
