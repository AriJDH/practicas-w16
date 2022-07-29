package vehiculos;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>(11);
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garage garage = new Garage(vehiculos);

        garage.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");

        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getPrecio))
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");

        List<Vehiculo> menores = garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getPrecio() <= 1000)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("---------------------------------------------------------------");

        List<Vehiculo> mayores = garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("---------------------------------------------------------------");

        OptionalDouble promedio = garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average();
        System.out.println(promedio);
    }
}
