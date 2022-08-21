package com.bootcamp.SocialMeli2.exceptions;

public class FollowedNotFoundException extends RuntimeException {

    public FollowedNotFoundException(String message) {
        super(message);
    }
}
