package Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        Vehiculo fordFiesta = new Vehiculo("Fiesta", "Ford", 1000);
        vehiculos.add(fordFiesta);
        Vehiculo fordFocus = new Vehiculo("Focus", "Ford", 1200);
        vehiculos.add(fordFocus);
        Vehiculo fordExplorer = new Vehiculo("Explorer", "Ford", 2500);
        vehiculos.add(fordExplorer);
        Vehiculo fiatUno = new Vehiculo("Uno", "Fiat", 500);
        vehiculos.add(fiatUno);
        Vehiculo fiatCronos = new Vehiculo("Cronos", "Fiat", 1000);
        vehiculos.add(fiatCronos);
        Vehiculo fiatTorino = new Vehiculo("Torino", "Fiat", 1250);
        vehiculos.add(fiatTorino);
        Vehiculo chevroletAveo = new Vehiculo("Aveo", "Chevrolet", 1250);
        vehiculos.add(chevroletAveo);
        Vehiculo chevroletSpin = new Vehiculo("Spin", "Chevrolet", 2500);
        vehiculos.add(chevroletSpin);
        Vehiculo toyotaCorola = new Vehiculo("Corola", "Toyota", 1200);
        vehiculos.add(toyotaCorola);
        Vehiculo toyotaFortuner = new Vehiculo("Fortuner", "Toyota", 3000);
        vehiculos.add(toyotaFortuner);
        Vehiculo renaultLogan = new Vehiculo("Logan", "Renault", 950);
        vehiculos.add(renaultLogan);


        Garage garage = new Garage(01, vehiculos);

        System.out.println(" ");

        System.out.println("Los precios ordenados de menor a mayor son: " );
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("");

        System.out.println("la lista Ordenada por marca y precio es la siguiente : ");
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("");

        System.out.println("Vehiculos con precio no mayor a 1000: ");
        vehiculos.stream()
                .filter(Vehiculo -> Vehiculo.getCosto() <= 1000).sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("");

        System.out.println("Vehiculos con precio mayor a 1000: ");
        vehiculos.stream()
                .filter(Vehiculo -> Vehiculo.getCosto() >= 1000).sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList()).forEach(System.out::println);


        Double precioTotal = vehiculos.stream().mapToDouble(Vehiculo::getCosto).sum();

        System.out.println(" ");

        System.out.println("El promedio  total de precios de todos los vehiculos es: " + precioTotal / vehiculos.size());


    }
}
