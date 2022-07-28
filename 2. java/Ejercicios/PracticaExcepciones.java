package com.bootcamp;

public class PracticaExcepciones {
   public static int a =0;
    public static int b =300;
    public static void main(String[] args) {


calcular();

    }

    public static void calcular(){
        try{
            int calculo=b/a;
        }catch(ArithmeticException e){
            throw new IllegalArgumentException ("No se puede dividir entre cero");
        }
        finally {
            {
                System.out.println("Programa finalizado");
            }
        }


    }
}
