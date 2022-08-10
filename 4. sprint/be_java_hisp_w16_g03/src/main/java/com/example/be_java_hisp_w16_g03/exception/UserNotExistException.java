package com.example.be_java_hisp_w16_g03.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(Integer id) {
        super("no existe el user con el id : " + id);
    }
}
