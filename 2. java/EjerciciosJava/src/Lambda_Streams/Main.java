package Lambda_Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.0));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.0));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.0));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        vehiculos.add(new Vehiculo("Toyota", "Corolla", 1200.0));
        vehiculos.add(new Vehiculo("Toyota", "Fortune", 3000.0));
        vehiculos.add(new Vehiculo("Reanult", "Logan", 950.0));

        Garage g = new Garage(vehiculos, 1234);

        g.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getPrecio))
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");

        g.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getPrecio() < 1000.0)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");

        g.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000.0)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");

        System.out.println("Promedio: " + g.getVehiculos().stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average().getAsDouble());

    }
}
