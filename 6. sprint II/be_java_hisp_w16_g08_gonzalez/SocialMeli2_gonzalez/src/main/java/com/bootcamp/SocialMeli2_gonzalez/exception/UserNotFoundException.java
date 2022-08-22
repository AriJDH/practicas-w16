package com.bootcamp.SocialMeli2_gonzalez.exception;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends RuntimeException {
    private final HttpStatus htttpStatus;
    private final String exception;

    public UserNotFoundException() {
        super("User not found");
        this.htttpStatus = HttpStatus.NOT_FOUND;
        this.exception = "Not Found";
    }
}
