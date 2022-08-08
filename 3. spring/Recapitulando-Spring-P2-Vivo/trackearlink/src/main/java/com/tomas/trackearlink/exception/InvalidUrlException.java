package com.tomas.trackearlink.exception;

public class InvalidUrlException extends RuntimeException{
    public InvalidUrlException (String url){
        super("The url:" + url + " is invalid");
    }
}