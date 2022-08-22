package com.example.be_java_hisp_w16_g03.exception;

public class AlreadyFollowException extends RuntimeException {
    public AlreadyFollowException(Integer id, Integer idFollow) {
        super("El usuario con el id: " + id + " ya es seguidor de : " + idFollow);
    }

}
