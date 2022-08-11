package com.bootcamp.be_java_hisp_w16_g7_espitia.exception;

public class UserExistsException extends RuntimeException{
    public UserExistsException(int userId){
        super ("User whit id "+ userId+" exists");
    }
}
