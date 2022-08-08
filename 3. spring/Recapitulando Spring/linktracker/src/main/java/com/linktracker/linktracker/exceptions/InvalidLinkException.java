package com.linktracker.linktracker.exceptions;

import lombok.Data;

@Data
public class InvalidLinkException extends RuntimeException{
    private String link;

    public InvalidLinkException(){
        
    }

    public InvalidLinkException(String message) {
        super(message);
    }

    public InvalidLinkException(String message, String link) {
        super(message + ":" + link);
        this.link = link;
    }
}
