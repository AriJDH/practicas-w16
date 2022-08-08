package Ejercicio1;

import java.util.Scanner;

public class News {

    private Scanner teclado;
    private String[] cities;
    private int[][] temperatures;
    private int filas;
    private int columnas;
    private String values;
    private int maxTemperature;
    private int minTemperature;

    // Cargar ciudades
    public void loadCities() {
        teclado = new Scanner(System.in);
        filas = 10;
        cities = new String[filas];

        for (int i = 0; i < cities.length; i++) {
            System.out.println("Ingrese ciudad: ");
            cities[i] = teclado.nextLine();
        }
        System.out.println();
    }

    // Cargar temperaturas
    public void loadTemperatures() {
        teclado = new Scanner(System.in);
        filas = 10;
        columnas = 2;
        temperatures = new int[filas][columnas];
        values = "";

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (j == 0) {
                    values = "MINIMA";
                } else {
                    values = "MAXIMA";
                }

                System.out.println("Ingrese la temperatura " + values + " para la ciudad de " + cities[i].toUpperCase());
                temperatures[i][j] = teclado.nextInt();
            }
        }
        System.out.println();

    }

    // Mostrar ciudades
    public void showCities() {
        System.out.println("Ciudades registradas: ");
        for (int i = 0; i < cities.length; i++) {
            System.out.println("- " + cities[i].toUpperCase());
        }
        System.out.println();
    }

    // Mostrar temperaturas
    public void showTemperatures() {
        System.out.println("Temperaturas registradas: \n");
        for (int i = 0; i < filas; i++) {
            System.out.println(cities[i].toUpperCase());
            for (int j = 0; j < columnas; j++) {
                System.out.print(" " + temperatures[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Calcular temperatura minima y maxima
    public void showMaxAndMinTemperature() {
        maxTemperature = 0;
        minTemperature = 0;
        String cityMax = "";
        String cityMin = "";

        for (int i = 0; i < filas; i++) {
            for (int j = 1; j < 2; j++) {
                if (maxTemperature < temperatures[i][j]) {
                    maxTemperature = temperatures[i][j];
                    cityMax = cities[i];
                }
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 1; j++) {
                if (minTemperature > temperatures[i][j]) {
                    minTemperature = temperatures[i][j];
                    cityMin = cities[i];
                }
            }

        }

        System.out.println("Temperatura minima: " + minTemperature + "°C en la ciudad de " + cityMin.toUpperCase());
        System.out.println("Temperatura maxima: " + maxTemperature + "°C en la ciudad de " + cityMax.toUpperCase());
    }

    public static void main(String[] args) {

        News news = new News();

        news.loadCities();
        news.showCities();
        news.loadTemperatures();
        news.showTemperatures();
        news.showMaxAndMinTemperature();

    }

}
