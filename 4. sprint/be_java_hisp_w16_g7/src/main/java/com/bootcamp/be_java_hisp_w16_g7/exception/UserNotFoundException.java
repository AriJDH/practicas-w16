package com.bootcamp.be_java_hisp_w16_g7.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(int idUser) {
        super("User whit id: " + idUser + " not found");
    }
}
