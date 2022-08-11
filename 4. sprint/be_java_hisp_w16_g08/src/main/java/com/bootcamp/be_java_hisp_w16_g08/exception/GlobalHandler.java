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

    @ExceptionHandler(UserNotVendorException.class)
    public ResponseEntity<ResponseApiDto> catchUserNotVendorException(UserNotVendorException e){
        ResponseApiDto exceptionApiDTO = new ResponseApiDto("User not vendor");
        return  new ResponseEntity<>(exceptionApiDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AlreadyFollowAUserException.class)
    public  ResponseEntity<ResponseApiDto> catchAlreadyFollowAUserException(AlreadyFollowAUserException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("Already follow this user");
        return  new ResponseEntity<>(exceptionApiDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CanNotFollowYourSelfException.class)
    public  ResponseEntity<ResponseApiDto> catchCanNotFollowYourSelfException(CanNotFollowYourSelfException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("Can not follow yourself");
        return  new ResponseEntity<>(exceptionApiDto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(OrderNotPossibleException.class)
    public  ResponseEntity<ResponseApiDto> catchOrderNotPossibleException(OrderNotPossibleException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("That sorting order is not valid");
        return  new ResponseEntity<>(exceptionApiDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IncorretPostInformationException.class)
    public ResponseEntity<ResponseApiDto> catchIncorretPostInformationException(IncorretPostInformationException e){
        ResponseApiDto exceptionApiDto = new ResponseApiDto("Incorrect post information");
        return new ResponseEntity<>(exceptionApiDto, HttpStatus.BAD_REQUEST);
    }



}
