package com.example.be_java_hisp_w16_g09.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException (int id){
        super(String.format("Post with id: %d not found",id));
    }
}
