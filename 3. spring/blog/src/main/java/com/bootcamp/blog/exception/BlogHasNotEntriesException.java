package com.bootcamp.blog.exception;

public class BlogHasNotEntriesException extends RuntimeException{
    public BlogHasNotEntriesException (){
        super("The blog has no entries");
    }
}
