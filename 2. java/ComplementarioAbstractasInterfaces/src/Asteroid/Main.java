package Asteroid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args){

    List<String> participantes = new ArrayList<String>();
    List<String> distancias = new ArrayList<String>();

    NaveSimple nave1 = new NaveSimple("Nave 1", 1, 8);
    NaveSimple nave2 = new NaveSimple("Nave 2", 2, 7);
    NaveSimple nave3 = new NaveSimple("Nave 3", 3, 8);
    NaveSimple nave4 = new NaveSimple("Nave 4", 7, 9);
    NaveSimple nave5 = new NaveSimple("Nave 5", 6, 7);
    NaveSimple nave6 = new NaveSimple("Nave 6", 4, 6);

    List<NaveSimple> naves1 = Arrays.asList(new NaveSimple[]{nave1, nave2, nave3});
    FlotaNaves flota1 = new FlotaNaves(naves1);

    List<NaveSimple> naves2 = Arrays.asList(new NaveSimple[]{nave4, nave5, nave6});
    FlotaNaves flota2 = new FlotaNaves(naves2);

    System.out.println("BIENVENIDO A ASTEROID");
    System.out.println("Ingrese número de participantes");
    Scanner input = new Scanner(System.in);

    int num = input.nextInt();
    int coordenadas[][] = new int[num][2];
    double min = 100000;

    for (int i=0; i<num; i++){
      double sumdistancia = 0;
      System.out.println("Ingrese el nombre del participante: "+(i+1));
      participantes.add(input.nextLine());
      System.out.println("Ingrese las coordenadas del Blanco "+(i+1));
      System.out.println("Ingrese la coordenada en X");
      int x = input.nextInt();
      System.out.println("Ingrese la coordenada en Y");
      int y = input.nextInt();
      coordenadas[i][0] = x;
      coordenadas[i][1] = y;
      sumdistancia = nave1.calcularDistancia(x,y) +
          nave2.calcularDistancia(x,y) +
          nave3.calcularDistancia(x,y) +
          nave4.calcularDistancia(x,y) +
          nave5.calcularDistancia(x,y) +
          nave6.calcularDistancia(x,y) +
          flota1.calcularDistancia(x,y) +
          flota2.calcularDistancia(x,y);
    }
  }
}
