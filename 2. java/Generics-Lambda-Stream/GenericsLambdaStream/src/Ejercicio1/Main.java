package Ejercicio1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> vehiculos = llenarVehiculos();

        System.out.println("Ordenado por precio");
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println("");

        System.out.println("Ordenado por precio y marca");
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto).thenComparing(Comparator.comparing(Vehiculo::getMarca)))
                .forEach(System.out::println);
        System.out.println("");

        System.out.println("Lista de vehículos con precio no mayor a 1000");
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("");

        System.out.println("Lista de vehículos con precio no mayor a 1000");
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);
        System.out.println("");

        System.out.println("precios mayor o igual 1000");
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);
        System.out.println("");

        System.out.println("promedio de costo: " +
                vehiculos.stream()
                .mapToDouble(vehiculo -> vehiculo.getCosto())
                .average());

        System.out.println("");


    }
    public static List<Vehiculo> llenarVehiculos(){
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculos.add(new Vehiculo("Ford","Focus",1200));
        vehiculos.add(new Vehiculo("Ford","Explorer",2500));
        vehiculos.add(new Vehiculo("Fiat","Uno",500));
        vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        vehiculos.add(new Vehiculo("Renault","Logan",950));
        return vehiculos;
    }



}


