package com.example.Sprint1.exception;

public class InvalidDateException extends RuntimeException{
    public InvalidDateException(String date){
        super("Invalid date: " + date);
    }
}
