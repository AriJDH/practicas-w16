package com.bootcamp.SocialMeli2.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ValidateFieldExceptionDto {
    private String exception;
    private HttpStatus status;
    private String messageException;
    HashMap<String, List<String>> errors = new HashMap<>();
}
