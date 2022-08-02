package vehiculos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000.0));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200.0));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500.0));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500.0));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000.0));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250.0));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500.0));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1250.0));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000.0));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950.0));

        Garage g = new Garage(1, vehiculos);
        System.out.println("Ordenados por precio");
        g.getVehiculos().stream().sorted((ve1, ve2) -> ve1.getCosto().compareTo(ve2.getCosto())).forEach(System.out::println);
        System.out.println("______________________________________________");
        System.out.println("Ordenados por precio y modelo");
        Comparator<Vehiculo> marcaYPrecioComparador = Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto);
        g.getVehiculos().stream().sorted(marcaYPrecioComparador).forEach(System.out::println);
        System.out.println("______________________________________________");
        System.out.println("Vehiculos menores a $1000");
        g.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
        System.out.println("______________________________________________");
        System.out.println("Vehiculos mayor o igual a $1000");
        g.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() >= 1000).forEach(System.out::println);
        System.out.println("______________________________________________");
        System.out.println("Promedio de precios");
        OptionalDouble promedio = g.getVehiculos().stream().mapToDouble(v -> v.getCosto()).average();
        System.out.println(promedio.getAsDouble());

    }
}
