package vehiculos;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = List.of(
                new Vehiculo( "Fiesta", "Ford", 1000),
                new Vehiculo( "Focus", "Ford", 1200),
                new Vehiculo("Explorer", "Ford", 2500),
                new Vehiculo("Uno", "Fiat",  500),
                new Vehiculo( "Cronos", "Fiat",  1000),
                new Vehiculo( "Torino", "Fiat",  1250),
                new Vehiculo( "Aveo", "Chevrolet",1250),
                new Vehiculo("Spin","Chevrolet", 2500),
                new Vehiculo( "Corola", "Toyota",1200),
                new Vehiculo( "Fortuner", "Toyota", 3000),
                new Vehiculo( "Logan","Renault", 950));

        Garaje garaje = new Garaje(vehiculos);

        System.out.println("---Ordenar vehiculos por precio de menor a mayor---");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("");
        System.out.println("---Ordenar vehiculos por marca y por precio---");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca))
                .forEach(System.out::println);

        System.out.println("");
        System.out.println("---Filtrar por precio menor a 1000---");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000).forEach(System.out::println);

        System.out.println("");
        System.out.println("---Filtrar por precio mayor o igual a 1000---");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);

        System.out.println("");
        System.out.println("---Promedio de todos los precios de la lista---");
        System.out.println(garaje.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble());
        
    }
}
