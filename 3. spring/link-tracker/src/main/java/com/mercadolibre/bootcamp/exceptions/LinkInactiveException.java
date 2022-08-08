package com.mercadolibre.bootcamp.exceptions;

public class LinkInactiveException extends RuntimeException {
    public LinkInactiveException(String id) {
        super("The url with " + id + " is inactive");
    }
}
