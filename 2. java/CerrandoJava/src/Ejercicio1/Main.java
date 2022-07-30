package Ejercicio1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaDeVehiculos = new ArrayList<>(Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortunet", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

        Garaje garage = new Garaje(1, listaDeVehiculos);

        // Ejercicio 3: Ordenar vehiculos por precio de menor a mayor.
        System.out.println("-----------------");
        System.out.println("Lista Ordenada por precio.");
        listaDeVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        // Ejercicio 4: Ordenar vehículos por marca y costo
        System.out.println("-----------------");
        System.out.println("Lista ordenada por marca y precio.");
        listaDeVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        // Ejercicio 5: Extraer lista de vehiculos con
        //  precio mayor o igual a 1000 y
        //  obtener promedio total de toda la lista.
        System.out.println("-----------------");
        System.out.println("Lista filtrada.");
        // Lista filtrada
        List<Vehiculo> listaFiltrada =
                listaDeVehiculos.stream()
                .filter((vehiculo -> vehiculo.getCosto()<=1000))
                .collect((Collectors.toList()));

        listaFiltrada.forEach(System.out::println);

        // Promedio costo:
        double avg = listaDeVehiculos.stream()
                .mapToDouble((vehiculo)-> vehiculo.getCosto())
                .average().getAsDouble();

        System.out.println("Promedio: " + avg);

    }
}
