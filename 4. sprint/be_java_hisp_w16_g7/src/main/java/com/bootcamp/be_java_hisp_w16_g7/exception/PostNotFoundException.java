package com.bootcamp.be_java_hisp_w16_g7.exception;

public class PostNotFoundException extends RuntimeException{

    public PostNotFoundException(){
        super("Not found post");
    }
}
