package com.example.obrasliterarias.exception;

public class ObraNotFoundException extends RuntimeException {
    public ObraNotFoundException(String id) {
        super("No se encontró la obra con id " + id);
    }
}
