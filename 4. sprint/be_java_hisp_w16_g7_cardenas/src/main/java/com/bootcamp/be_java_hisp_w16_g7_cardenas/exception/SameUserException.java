package com.bootcamp.be_java_hisp_w16_g7_cardenas.exception;

public class SameUserException extends RuntimeException{
    public SameUserException(int id) {
        super("Both user id ("+id+") are the same, cannot perform this action");
    }

}
