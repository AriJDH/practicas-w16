package com.bootcamp.be_java_hisp_w16_g08.exception;
import com.bootcamp.be_java_hisp_w16_g08.dto.response.ResponseApiDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class GlobalHandler {
    @ExceptionHandler()
    public ResponseEntity<ResponseApiDto> catchUserNotFollowException(UserNotFolllowException e) {
        ResponseApiDto exceptionDTO = new ResponseApiDto(e.getMessage());
        return new ResponseEntity<>(exceptionDTO, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ResponseApiDto> catchException(UserNotFoundException e) {
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("User was not found");
        return new ResponseEntity<>(exceptionApiDTO, HttpStatus.NOT_FOUND);
    }
}
