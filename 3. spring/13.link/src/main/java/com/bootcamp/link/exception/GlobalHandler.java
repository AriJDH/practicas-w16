package com.bootcamp.link.exception;

import com.bootcamp.link.dto.ResponseApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice()
public class GlobalHandler {

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ResponseApiDto> catchException(InvalidLinkException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Invalid link");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundLinkException.class)
    public ResponseEntity<ResponseApiDto> catchException(NotFoundLinkException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Link not found");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ResponseApiDto> catchException(UnauthorizedException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Not Authorized");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DisabledLinkException.class)
    public ResponseEntity<ResponseApiDto> catchException(DisabledLinkException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("Disabled Link");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.FORBIDDEN);
    }
}
