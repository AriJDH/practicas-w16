package RecapituladoJava;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000d));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200d));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500d));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500d));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000d));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250d));
        vehiculos.add(new Vehiculo("Cherolet", "Aveo", 1250d));
        vehiculos.add(new Vehiculo("Cherolet", "Spin", 2500d));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200d));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000d));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950d));

        Garage garage = new Garage(1, vehiculos);

        garage.getVehiculos().sort((o1, o2) -> o1.getCosto().compareTo(o2.getCosto()));
        System.out.println("Ordenada por precio solamente: " + garage.getVehiculos());

        Garage garage2 = new Garage(2, vehiculos);

        Comparator<Vehiculo> compararNombreYCosto = Comparator
                .comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto);

        garage2.getVehiculos().sort(compararNombreYCosto);

        System.out.println("Ordenada por precio y marca: " + garage2.getVehiculos());

        List<Vehiculo> menorA1000 = garage2.getVehiculos().stream()
                .filter((vehiculo -> vehiculo.getCosto() < 1000))
                .collect(Collectors.toList());

        System.out.println("Menor a 1000: " + menorA1000);

        List<Vehiculo> mayorA1000 = garage2.getVehiculos().stream()
                .filter((vehiculo -> vehiculo.getCosto() >= 1000))
                .collect(Collectors.toList());

        System.out.println("Menor a 1000: " + mayorA1000);

        Double avgCosto = garage2.getVehiculos().stream().mapToDouble(value -> value.getCosto()).average().getAsDouble();

        System.out.println("Promedio de costos: " + avgCosto);
    }
}
