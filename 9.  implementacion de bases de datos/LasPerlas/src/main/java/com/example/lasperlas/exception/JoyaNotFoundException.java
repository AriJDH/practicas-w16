package com.example.lasperlas.exception;

public class JoyaNotFoundException extends RuntimeException {
    public JoyaNotFoundException(Long id) {
        super("No se encontró la joya con id " + id);
    }
}
