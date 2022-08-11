package com.bootcamp.be_java_hisp_w16_g08_bracco.exception;
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
