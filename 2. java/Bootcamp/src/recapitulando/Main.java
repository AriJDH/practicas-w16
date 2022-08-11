package recapitulando;

import recapitulando.models.Garage;
import recapitulando.models.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.0));
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.0));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.0));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250.0));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950.0));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.0));

        Garage garage = new Garage(1, vehiculos);
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------");
        System.out.println("OPCION 1");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .sorted((x, y) -> x.getMarca().compareToIgnoreCase(y.getMarca()))
                .forEach(System.out::println);
        System.out.println("OPCION 2");
        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getPrecio))
                .forEach(System.out::println);
        System.out.println("------------------------------------------------------");
        System.out.println(garage.getVehiculos().stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average()
                .getAsDouble()
        );

    }
}
