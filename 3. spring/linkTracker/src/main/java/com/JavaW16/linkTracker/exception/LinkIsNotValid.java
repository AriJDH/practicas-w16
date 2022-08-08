package com.JavaW16.linkTracker.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class LinkIsNotValid extends RuntimeException{
    public LinkIsNotValid ( Integer query ) {
        super("El Link con el id: " + query + " esta invalidado");
    }
}
