package com.ndemaio.ejerciciocalculadoradecalorias.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

public class MealNotFoundException extends Exception {
    public MealNotFoundException(String aMessage) {
        super(aMessage);
    }
}
