package com.example.be_java_hisp_w16_g09.dto.exception;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String date){
        super("Invalid date: " + date);
    }
}
