package P1;

import java.util.Scanner;

public class EjercicioUno {
    public static void main(String[] args) {
        int CANT_MAX_CITIES = 3;
        String[] cities = new String[CANT_MAX_CITIES];
        int[][] temperatures = new int[CANT_MAX_CITIES][2];
        Scanner input = new Scanner(System.in);

        for(int i = 0; i < CANT_MAX_CITIES; i++) {
            System.out.println("Ingresa el nombre de la ciudad");
            cities[i] = input.nextLine();

            System.out.println("Ingresa la temperatura minima");
            temperatures[i][0] = input.nextInt();
            input.nextLine();
            System.out.println("Ingresa la temperatura maxima");
            temperatures[i][1] = input.nextInt();
            input.nextLine();
        }


        String minCityName = cities[0];
        String maxCityName = cities[0];
        int min = temperatures[0][0];
        int max = temperatures[0][1];

        for (int i = 1; i < cities.length ; i++) {
            String currentCity = cities[i];
            int currentMin = temperatures[i][0];
            int currentMax = temperatures[i][1];
            if (currentMin < min) {
                minCityName = currentCity;
                min = currentMin;
            }
            if(currentMax > max) {
                maxCityName = currentCity;
                max = currentMax;
            }
        };
        System.out.println("El minimo es " + min + " en la ciudad " + minCityName);
        System.out.println("El maximo es " + max + " en la ciudad " + maxCityName);
    }

}
