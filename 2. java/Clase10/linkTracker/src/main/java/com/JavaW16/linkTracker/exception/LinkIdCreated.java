package com.JavaW16.linkTracker.exception;

public class LinkIdCreated extends  RuntimeException{
    public LinkIdCreated ( Integer query ) {
        super("Ya tenemos un Link con el id: " + query);
    }

}
