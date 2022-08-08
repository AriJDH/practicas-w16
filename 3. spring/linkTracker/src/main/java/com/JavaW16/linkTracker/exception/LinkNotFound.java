package com.JavaW16.linkTracker.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;

public class LinkNotFound extends RuntimeException{
    public LinkNotFound ( Integer query ) {
        super("No tenemos un Link con el id: " + query);
    }
}
