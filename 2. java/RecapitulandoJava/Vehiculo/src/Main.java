/*
    Autor: Tannia Lucía Hernández Rojas
    Practica integradora Vehiculos
    Generics + Wrapper + Lambda + Streams
* */


import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

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

        Garaje garaje = new Garaje(1, vehiculos);

        List<Vehiculo> vehiculosGaraje = garaje.getVehiculos();
        System.out.println("---------------------------------");
        //Ordenar los vehículos por precio de menor a mayor
        vehiculosGaraje.sort(
                Comparator.comparing(Vehiculo -> Vehiculo.getCosto()));
        System.out.println(vehiculosGaraje);

        System.out.println("------------------------------------");
        //Lista ordenada por marca y por precio
        vehiculosGaraje.sort(
                Comparator.comparing(Vehiculo ::getMarca)
                .thenComparingInt(Vehiculo :: getCosto));
        System.out.println(vehiculosGaraje);

        System.out.println("-------------------------------------");
        //Lista de vehiculos con precio no mayor a 1000
        vehiculosGaraje.stream()
                .filter(Vehiculo -> Vehiculo.getCosto()<1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-------------------------------------");
        //Lista de vehiculos con precio mayor o igual a 1000
        vehiculosGaraje.stream()
                .filter(Vehiculo -> Vehiculo.getCosto()>=1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-----------------------------------");
        //Promedio total de precios de toda la lista
        Double promedio = vehiculosGaraje.stream()
                .mapToInt(Vehiculo -> Vehiculo.getCosto())
                .average().getAsDouble();
        System.out.println("Promedio total de precios: "+promedio);
    }
}
