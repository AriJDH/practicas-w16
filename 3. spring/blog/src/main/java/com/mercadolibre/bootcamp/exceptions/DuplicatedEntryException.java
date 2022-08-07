package com.mercadolibre.bootcamp.exceptions;

public class DuplicatedEntryException extends RuntimeException{
    public DuplicatedEntryException (int id ) {
        super("Blog entry with id: " + id + " already exists" );
    }
}
