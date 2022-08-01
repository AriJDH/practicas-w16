package practica.recapjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculoUno = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculoDos = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculoTres = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculoCuatro = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculoCinco = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculoSeis = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculoSiete = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculoOcho = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculoNueve = new Vehiculo("Corolla", "Toyota", 1200);
        Vehiculo vehiculoDiez = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculoOnce = new Vehiculo("Logan", "Renault", 950);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>(Arrays.asList(vehiculoUno, vehiculoDos, vehiculoTres, vehiculoCuatro, vehiculoCinco, vehiculoSeis, vehiculoSiete, vehiculoOcho, vehiculoNueve, vehiculoDiez, vehiculoOnce));

        Garaje garaje = new Garaje(1, vehiculos);

        // ordeno los vehiculos en forma ascendente en base al precio
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        // ordeno los vehiculos por orden alfabetico de la marca
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .forEach(System.out::println);

        // filtro vehiculos de precio menor o igual a 1000
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .forEach(System.out::println);

        // filtro vehiculos de precio mayor o igual a 1000
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);

        // promedio
        double average = garaje.getVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println(average);

    }
}
