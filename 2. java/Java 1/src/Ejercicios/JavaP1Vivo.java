package Ejercicios;

import java.util.Scanner;

public class JavaP1Vivo {


    public static void main(String[] args)
    {
        String[] ciudades = new String[10];
        int[][] temperatura = new int[10][2];
        int temperatura_minima, temperatura_maxima = 0;
        String ciudad_minima = "", ciudad_maxima = "";
        Scanner teclado = new Scanner(System.in);
        for(int i = 0; i < temperatura.length; i++)
        {
            System.out.println("Ingrese la ciudad: ");
            ciudades[i]= teclado.next();
            for (int j = 0; j <temperatura[i].length; j++)
            {
                if(j== 0){
                    System.out.println("Ingrese la temperatura minima");
                    temperatura[i][j] = teclado.nextInt();
                }else{
                    System.out.println("Ingrese la temperatura máxima");
                    temperatura[i][j] = teclado.nextInt();
                }
            }
        }

        temperatura_minima = temperatura[0][0];
        temperatura_maxima = temperatura[0][1];
        for (int i = 0; i < temperatura.length; i++)
        {
                if(temperatura_minima > temperatura[i][0]) {
                    temperatura_minima = temperatura[i][0];
                    ciudad_minima = ciudades[i];
                }
                if(temperatura_maxima < temperatura[i][1])
                {
                    temperatura_maxima = temperatura[i][1];
                    ciudad_maxima = ciudades[i];
                }
        }
        System.out.println("La ciudad con la menor temperatura es: "+ciudad_minima+" con "+temperatura_minima+"°");
        System.out.println("La ciudad con la mayor temperatura es: "+ciudad_maxima+" con "+temperatura_maxima+"°");
    }

}
