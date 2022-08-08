package com.bootcamp.exceptions;

public class ExceptionOne {
    public int calculateQuotient(int a, int b) throws ArithmeticException {
        if(a==0)
            throw new IllegalArgumentException("No es posible dividir con cero");
        return b / a;
    }
}
