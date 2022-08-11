package com.bootcamp.be_java_hisp_w16_g7.exception;

public class NoPostWithProductTypeException extends RuntimeException{

    public NoPostWithProductTypeException(String type) {
        super("There are no posts with products type:  " + type);
    }
}
