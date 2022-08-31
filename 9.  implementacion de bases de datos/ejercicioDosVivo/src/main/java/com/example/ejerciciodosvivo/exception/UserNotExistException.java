package com.example.ejerciciodosvivo.exception;


public class UserNotExistException extends RuntimeException {
    public UserNotExistException(Long id) {
        super("no existe el user con el id : " + id);
    }
}