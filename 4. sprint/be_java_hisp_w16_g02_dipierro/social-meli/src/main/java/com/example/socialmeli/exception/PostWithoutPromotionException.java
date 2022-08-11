package com.example.socialmeli.exception;

public class PostWithoutPromotionException extends RuntimeException{
    public PostWithoutPromotionException(String msg){
        super(msg);
    }
}
