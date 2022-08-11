package com.example.be_java_hisp_w16_g03.exception;

public class NotPromoPostException extends RuntimeException{
    public NotPromoPostException() {
        super("El post no es promocional");
    }
}
