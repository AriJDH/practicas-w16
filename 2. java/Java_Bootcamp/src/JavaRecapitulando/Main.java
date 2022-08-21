package JavaRecapitulando;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> vehiculoList = new ArrayList<>();
        vehiculoList.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculoList.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculoList.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculoList.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculoList.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculoList.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculoList.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculoList.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculoList.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculoList.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculoList.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje1 = new Garaje(1, vehiculoList);

        System.out.println("Lista ordenada y por marca");
        garaje1.getVehiculos().stream()
                //.sorted((x, y) -> y.getCosto() - x.getCosto())
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nlista precio menor a 1000");
        garaje1.getVehiculos().stream()
                .filter(x -> x.getCosto() < 1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\nlista precio mayor o igual a 1000");
        garaje1.getVehiculos().stream()
                .filter(x -> x.getCosto() >= 1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        Garaje garaje2 = new Garaje(2, vehiculoList);
        IntSummaryStatistics promedio = garaje2.getVehiculos()
                .stream()
                .mapToInt(x -> x.getCosto())
                .summaryStatistics();

        System.out.println("\nPromedio: " + promedio.getAverage());
    }
}
