package com.bootcamp.exception;

public class OneExercise {

    public int divide(int a, int b) throws ArithmeticException{

        if(b==0) throw new IllegalArgumentException("No se puede dividir por cero");

        return a / b;
    }
}
