package com.tester.app.exception;

public class TestNotFoundException extends RuntimeException {
    public TestNotFoundException(Long id) {
        super("No se encontró el Test Case con id: " + id);
    }
}
