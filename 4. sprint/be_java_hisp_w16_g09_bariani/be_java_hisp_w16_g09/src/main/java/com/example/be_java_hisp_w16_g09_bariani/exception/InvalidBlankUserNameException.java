package com.example.be_java_hisp_w16_g09_bariani.exception;

public class InvalidBlankUserNameException extends RuntimeException {
    public InvalidBlankUserNameException() {
        super("Invalid username, must not be blank");
    }
}