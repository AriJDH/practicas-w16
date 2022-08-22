package com.example.be_java_hisp_w16_g03.exception;

public class NotFollowersException extends RuntimeException {
    public NotFollowersException(Integer id, Integer followId) {
        super("El id: " + id + " no sigue al usuario " + followId);
    }
}
