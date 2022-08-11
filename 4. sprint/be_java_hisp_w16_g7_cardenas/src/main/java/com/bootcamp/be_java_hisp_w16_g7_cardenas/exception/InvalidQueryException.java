package com.bootcamp.be_java_hisp_w16_g7_cardenas.exception;

public class InvalidQueryException extends RuntimeException {
    public InvalidQueryException() {
    }

    public InvalidQueryException(String query, String param) {
        super("Unknown query: " + query + "=" + param);
    }
}


