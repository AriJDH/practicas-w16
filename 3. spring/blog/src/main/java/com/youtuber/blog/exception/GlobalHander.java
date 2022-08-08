package com.youtuber.blog.exception;

import com.youtuber.blog.dto.ResponseApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHander {

    @ExceptionHandler(BlogDuplicateException.class)
    public ResponseEntity<ResponseApiDto> catchException(BlogDuplicateException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("El blog ya existe", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BlogNotFoundException.class)
    public ResponseEntity<ResponseApiDto> catchException(BlogNotFoundException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("El blog ya no existe", e.getMessage());
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
