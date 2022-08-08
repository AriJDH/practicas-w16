package com.linktracker.linktracker.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private String message;
    private String status;
    private int code;
    private Object data;

    public ErrorResponse(){
        this.timestamp = new Date();
    }

    public ErrorResponse(HttpStatus headers, String message){
        this();
        this.message = message;
        this.status = headers.name();
        this.code = headers.value();
    }

    public ErrorResponse(HttpStatus headers, String message, Object data){
        this(headers, message);
        this.data = data;
    }

}
