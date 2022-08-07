package com.mercadolibre.bootcamp.exceptions;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException (int id ) {
        super("Blog entry with id: " + id + " is not created yet" );
    }
}
