package com.JavaW16.linkTracker.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;


public class LinkPasswordIncorrect extends  RuntimeException{

    public LinkPasswordIncorrect ( String query ) {
        super("La password es incorrecta: " + query);
    }

}
