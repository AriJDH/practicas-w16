package com.bootcamp;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String ciudades[] = new String[10];
    int temperaturas[][] = new int[10][2];
    String separador = "===================================";

    int temperaturaMaxima = 0, temperaturaMinima = 0, indiceMaximo = 0, indiceMinimo = 0;

    Scanner inputString = new Scanner(System.in);
    Scanner inputInt = new Scanner(System.in);

    System.out.println(separador);
    System.out.println("Temperaturas globales");
    System.out.println(separador);

    for (int i = 0; i < ciudades.length; i++) {
      System.out.println("Ingrese el nombre de la ciudad: ");
      ciudades[i] = inputString.nextLine();
      System.out.println("Ingrese la temperatura minima");
      temperaturas[i][0] = inputInt.nextInt();
      System.out.println("Ingrese la temperatura maxima");
      temperaturas[i][1] = inputInt.nextInt();
      System.out.println(separador);

      if (temperaturas[i][0] < temperaturaMinima) {
        temperaturaMinima = temperaturas[i][0];
        indiceMinimo = i;
      }
      if (temperaturas[i][1] > temperaturaMaxima) {
        temperaturaMaxima = temperaturas[i][1];
        indiceMaximo = i;
      }
    }

    System.out.println("La menor temperatura la tuvo " + ciudades[indiceMinimo] + ", con " + temperaturaMinima + " º C.");
    System.out.println("La mayor temperatura la tuvo " + ciudades[indiceMaximo] + ", con " + temperaturaMaxima + " º C.");
    System.out.println(separador);
  }
}
