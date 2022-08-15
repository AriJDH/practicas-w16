package com.main;

import com.clases.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo(1,"Fiesta", "Ford", 1000.0));
        vehiculos.add(new Vehiculo(2, "Focus", "Ford", 1200.0));
        vehiculos.add(new Vehiculo(3, "Explorer", "Ford", 2500.0));
        vehiculos.add(new Vehiculo(4, "Uno", "Fiat", 500.0));
        vehiculos.add(new Vehiculo(5, "Cronos", "Fiat", 1000.0));
        vehiculos.add(new Vehiculo(6, "Torino", "Fiat", 1250.0));
        vehiculos.add(new Vehiculo(7, "Aveo", "Chevrolet", 1250.0));
        vehiculos.add(new Vehiculo(8, "Spin", "Chevrolet", 2500.0));
        vehiculos.add(new Vehiculo(9, "Corola", "Toyota", 1200.0));
        vehiculos.add(new Vehiculo(10, "Fortuner", "Toyota", 3000.0));
        vehiculos.add(new Vehiculo(11, "Logan", "Renault", 950.0));

        //Ordernar precio de manera ascendente

        Comparator<Vehiculo> precioAsc = Comparator.comparing(Vehiculo::getCosto);
        List<Vehiculo> vehiculosPrecioAsc = vehiculos.stream().sorted(precioAsc).collect(Collectors.toList());
        System.out.println("Precio ascendente" +
                "\n" +vehiculosPrecioAsc);

        //Ordernar precio de manera desendente

        Comparator<Vehiculo> precioDes = Comparator.comparing(Vehiculo::getCosto).reversed();
        List<Vehiculo> vehiculosPrecioDes = vehiculos.stream().sorted(precioDes).collect(Collectors.toList());
        System.out.println("Precio Desendente" +
                "\n" + vehiculosPrecioDes);

        //Ordenar por marca y precio

        Comparator<Vehiculo> marcaPrecio = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        List<Vehiculo> vehiculosMarcaPrecio = vehiculos.stream().sorted(marcaPrecio).collect(Collectors.toList());
        System.out.println("Ordenar por marca y precio" +
                "\n" + vehiculosMarcaPrecio);


        //obtenr vehiculos no mayor a mil

        List<Vehiculo> vehiculosMenoresMil = vehiculos.stream().filter(x -> x.getCosto() < 1000).collect(Collectors.toList());
        System.out.println("" +
                "Vehiculos Menores a mil" +
                "\n" + vehiculosMenoresMil);

        //obtener vehiculos mayores o iguales a mil

        List<Vehiculo> vehiculosMayoresIguales = vehiculos.stream().filter(x -> x.getCosto() >= 1000).collect(Collectors.toList());
        System.out.println("" +
                "Vehiculos mayores o igual a mil" +
                "\n" + vehiculosMayoresIguales);

        //Obtener el promedio de todos lo vehiculos

        Double promedio = vehiculos.stream()
                .mapToDouble(x -> x.getCosto())
                .average()
                .getAsDouble();
        System.out.println("Promedio del precio de vehiculos \n" + promedio);
    }
}
