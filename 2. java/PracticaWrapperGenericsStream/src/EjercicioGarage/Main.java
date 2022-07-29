package EjercicioGarage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corolla", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        System.out.println("Ordenados por precio");
        List<Vehiculo> vehiculosOrdenados = vehiculos.stream()
                .sorted((x, y) -> Double.compare(x.getCosto(), y.getCosto()))
                .collect(Collectors.toList());

        vehiculosOrdenados.forEach(System.out::println);

        System.out.println("--------------------------");

        System.out.println("Ordenados por marca y precio");
        Comparator<Vehiculo> compareMarcaCosto = Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto);

        List<Vehiculo> vehiculosXMarcaYPrecio = vehiculos.stream()
                .sorted(compareMarcaCosto)
                .collect(Collectors.toList());

        vehiculosXMarcaYPrecio.forEach(System.out::println);

        System.out.println("--------------------------");

        System.out.println("Precios menor a 1000");
        List<Vehiculo> vehiculosMenor1000 = vehiculos.stream()
                .filter(x -> x.getCosto() < 1000)
                .collect(Collectors.toList());

        vehiculosMenor1000.forEach(System.out::println);

        System.out.println("--------------------------");

        System.out.println("Precios mayor a 1000");
        List<Vehiculo> vehiculosMayor1000 = vehiculos.stream()
                .filter(x -> x.getCosto() > 1000)
                .collect(Collectors.toList());

        vehiculosMayor1000.forEach(System.out::println);

        System.out.println("--------------------------");

        System.out.println("Promedio precios");
        double avg = vehiculos.stream()
                .mapToDouble(x -> x.getCosto())
                .average()
                .orElse(0.00);

        System.out.println(avg);
    }
}
