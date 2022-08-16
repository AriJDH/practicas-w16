package com.bootcamp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String vectorCiudades[] = new String[10];
        double matrizTemperaturas[][] = new double[10][2];
        double tempMinima, tempMaxima;
        String ciudadMinima, ciudadMaxima;


        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);

        System.out.println("------------------------------------------------------");
        System.out.println("////SOFTWARE de Temperaturas Globales////");
        System.out.println("------------------------------------------------------");
        System.out.println("Cargue los datos de las ciudades y sus temperaturas mínimas y máximas");
        //Recorrido de carga de datos para el vector y la matriz
        for (int f = 0; f <= 9; f++) {
            System.out.println("------------------------------------------------------");
            System.out.println("Ingrese el nombre de la ciudad en la posicion: " + f);
            vectorCiudades[f] = teclado.nextLine();

            for (int c = 0; c <= 1; c++) {
                if (c == 0) {
                    System.out.println("Ingrese la temperatura mínima para la ciudad de: " + vectorCiudades[f]);
                    matrizTemperaturas[f][c] = teclado2.nextInt();
                } else {
                    System.out.println("Ingrese la temperatura máxima para la ciudad de: " + vectorCiudades[f]);
                    matrizTemperaturas[f][c] = teclado2.nextInt();
                }
            }

        }
        //Se utiliza variables auxiliares para guardar las temperaturas y ciudades
        tempMinima = matrizTemperaturas[0][0];
        ciudadMinima = vectorCiudades[0];
        tempMaxima = matrizTemperaturas[0][0];
        ciudadMaxima = vectorCiudades[0];
        //Recorrido para encontrar la temperatura mínima y máxima
        for (int f = 0; f <= 9; f++) {
            for (int c = 0; c <= 1; c++) {

                //Condición para encontrar la temperatura mínima y guardar la ciudad que posea la misma
                if (matrizTemperaturas[f][c]<tempMinima){
                    tempMinima=matrizTemperaturas[f][c];
                    ciudadMinima=vectorCiudades[f];
                }
                //Condición para encontrar la temperatura máxima y guardar la ciudad que posea la misma
                if (matrizTemperaturas[f][c]>tempMaxima){
                    tempMaxima=matrizTemperaturas[f][c];
                    ciudadMaxima=vectorCiudades[f];
                }

            }

        }
        System.out.println("-------------------");
        System.out.println("---INFORME FINAL---");
        System.out.println("-------------------");
        System.out.println("La ciudad de " + ciudadMinima + " es la ciudad con la temperatura mínima de: " + tempMinima);
        System.out.println("La ciudad de " + ciudadMaxima + " es la ciudad con la temperatura máxima de: " + tempMaxima);
        System.out.println("------------------------------------------------------------------------------------------");
    }
}
