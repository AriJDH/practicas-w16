package com.example.be_java_hisp_w16_g03.exception;

public class InvalidOrderTypeException extends RuntimeException {

    public InvalidOrderTypeException(String query) {
        super("El tipo de ordenamiento '" + query + "' es incorrecto.");
    }

}
