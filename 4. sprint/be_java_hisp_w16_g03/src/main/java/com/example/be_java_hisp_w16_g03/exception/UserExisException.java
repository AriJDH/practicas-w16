package com.example.be_java_hisp_w16_g03.exception;

public class UserExisException extends  RuntimeException{
    public UserExisException (Integer id) {
        super("Ya tenemos un usuario con el id : " + id);
    }

}
