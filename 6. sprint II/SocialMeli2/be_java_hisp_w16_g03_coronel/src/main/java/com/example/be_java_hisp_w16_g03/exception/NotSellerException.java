package com.example.be_java_hisp_w16_g03.exception;

public class NotSellerException extends RuntimeException {
    public NotSellerException(Integer id) {
        super("El Usuario: " + id + " no es vendedor");
    }
}
