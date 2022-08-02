package com.prueba;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PruebaTry {

    public static int dividendo = 5;
    public  static int divisor = 0;
    public void falla(){
        try {
            FileInputStream fileInputStream = new FileInputStream("Prueba.txt");
        }catch (FileNotFoundException exception){
            exception.printStackTrace();
        }
    }

    public void fallaThrow(){
        try{
            if (divisor == 0)
                throw new IllegalAccessException("No se puede dividir por cero");
        }catch (IllegalAccessException exception){
            exception.printStackTrace();
        }
    }

    public void divisionCero(){

        try{
            double division = 5 / 0;
        }catch (ArithmeticException exception){
            System.out.println("Error en la division: " + exception.getMessage());
        }finally {
            System.out.println("Despues de la division");
        }

    }

    public double division_real (double dividendo, double divisor) throws Exception{
        double aux;
        if(divisor != 0){
            aux = dividendo/divisor;
        }else{
            throw new Exception();
        }
        return aux;
    }
}
