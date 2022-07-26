package practico;

import java.util.Scanner;

public class Practico1 {

    public static void main(String[] args) {
        int CANT_CIUDADES = 2;  //Para facilitar pruebas, se asigna un valor a la constante para elegir la cantidad de ciudades a ingresar.
        String ciudades[] = new String[CANT_CIUDADES];
        int temperaturas[][] = new int[ciudades.length][2];

        Scanner entradaCiudad = new Scanner(System.in);
        Scanner entradaTemp = new Scanner(System.in);

        System.out.println("Cargar las ciudades y sus temperaturas máximas y mínimas");
        System.out.println();

        for (int i = 0; i < ciudades.length; i++) {
            System.out.println("Ingrese el nombre de la ciudad [" + i + "]: ");
            ciudades[i] = entradaCiudad.nextLine();

            for (int j = 0; j < temperaturas[i].length; j++) {
                if (j == 0) {
                    System.out.print("Ingrese la temperatura MÍNIMA para la ciudad "+ ciudades[i] + " ["+i+"]: ");
                } else {
                    System.out.print("Ingrese la temperatura MÁXIMA para la ciudad "+ ciudades[i] + " ["+i+"]: ");
                }
                temperaturas[i][j] = entradaTemp.nextInt();
            }
            System.out.println();
        }

        int tempMinima, tempMaxima;
        tempMaxima = tempMinima = temperaturas[0][0];
        String ciudadMax, ciudadMin;
        ciudadMax = ciudadMin = ciudades[0];

        for (int x = 0; x < ciudades.length; x++) {
            for (int y = 0; y < temperaturas[x].length; y++) {
                if (temperaturas[x][y]<tempMinima){
                    tempMinima=temperaturas[x][y];
                    ciudadMin=ciudades[x];
                }

                if (temperaturas[x][y]>tempMaxima){
                    tempMaxima=temperaturas[x][y];
                    ciudadMax=ciudades[x];
                }
            }
        }

        System.out.println("--- INFORMACIÓN ---");
        System.out.println("La ciudad de " + ciudadMin + " tuvo la temperatura mínima de: " + tempMinima);
        System.out.println("La ciudad de " + ciudadMax + " tuvo la temperatura máxima de: " + tempMaxima);

    }

}
