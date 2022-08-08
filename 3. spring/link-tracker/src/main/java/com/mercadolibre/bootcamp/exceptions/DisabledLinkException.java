package com.mercadolibre.bootcamp.exceptions;

public class DisabledLinkException extends RuntimeException {
    public DisabledLinkException(String id) {
        super("Link with id: " + id + " is disabled.");
    }
}
