package com.bootcamp.be_java_hisp_w16_g08.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id){
        super("The user with id: " + id + " has not been found");
    }
}
