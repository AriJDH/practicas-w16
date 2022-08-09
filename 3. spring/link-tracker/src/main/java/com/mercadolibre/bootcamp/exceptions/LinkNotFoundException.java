package com.mercadolibre.bootcamp.exceptions;

public class LinkNotFoundException extends RuntimeException{
    public LinkNotFoundException (String id){
        super("The id: " + id + " has not been found");
    }
}
