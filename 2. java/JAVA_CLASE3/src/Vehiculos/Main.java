package Vehiculos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

            Vehiculo veh1 = new Vehiculo("Ford", "Fiesta", 1000.0);
            Vehiculo veh2 = new Vehiculo("Ford", "Focus", 1200.0);
            Vehiculo veh3 = new Vehiculo("Ford", "Explorer", 2500.0);
            Vehiculo veh4 = new Vehiculo("Fiat", "Uno", 500.0);
            Vehiculo veh5 = new Vehiculo("Fiat", "Cronos", 1000.0);
            Vehiculo veh6 = new Vehiculo("Fiat", "Torino", 1250.0);
            Vehiculo veh7 = new Vehiculo("Chevrolet", "Aveo", 1250.0);
            Vehiculo veh8 = new Vehiculo("Chevrolet", "Spin", 2500.0);
            Vehiculo veh9 = new Vehiculo("Toyota", "Corola", 1200.0);
            Vehiculo veh10 = new Vehiculo("Toyota", "Fortuner", 3000.0);
            Vehiculo veh11 = new Vehiculo("Renault", "Logan", 950.0);

            List<Vehiculo> vehiculos = new ArrayList<>();
            vehiculos.add(veh1);
            vehiculos.add(veh2);
            vehiculos.add(veh3);
            vehiculos.add(veh4);
            vehiculos.add(veh5);
            vehiculos.add(veh6);
            vehiculos.add(veh7);
            vehiculos.add(veh8);
            vehiculos.add(veh9);
            vehiculos.add(veh10);
            vehiculos.add(veh11);

            Garaje garaje = new Garaje(001, vehiculos);

            System.out.println(garaje);

            System.out.println("\nOrdenado por precios de menor a mayor");
            vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                    .forEach(System.out::println);
            System.out.println();

            garaje.getVehiculos().stream()
                    .sorted(Comparator.comparing(vehiculo -> vehiculo.getCosto())).forEach(value -> System.out.println(value));

            vehiculos.stream()
                    .sorted(Comparator.comparing(Vehiculo::getMarca))
                    .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                    .forEach(System.out::println);

            vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

            System.out.println();
            System.out.println("\nOrdenado por marca y precio");
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo);
            }

            System.out.println("\nMenor a 1000");
            vehiculos.stream().filter(x -> x.getCosto() < 1000)
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("\nMayor o igual a mil");
            vehiculos.stream().filter(x -> x.getCosto() >= 1000)
                    .forEach(System.out::println);

            System.out.println();
            System.out.println("\nPromedio");
            double promedio = vehiculos.stream().mapToDouble(x -> x.getCosto()).average().orElse(0.00);
            System.out.println(promedio);


        }

}
