package com.bootcamp.linktracer.exception;

public class InvalidUrlException extends RuntimeException {
    public InvalidUrlException(String url) {
        super("La url " + url + " no es una url válida");
    }
}
