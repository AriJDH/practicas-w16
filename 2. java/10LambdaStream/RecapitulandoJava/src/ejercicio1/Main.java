package ejercicio1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Vehiculo veh1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo veh2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo veh3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo veh4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo veh5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo veh6 = new Vehiculo("Fiat", "Torino", 1250);

        Vehiculo veh7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo veh8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo veh9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo veh10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo veh11 = new Vehiculo("Renault", "Logan", 950);

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

        Garage garage = new Garage(1, vehiculos);

        System.out.println(garage);


        //ordena por  precio
        System.out.println();
        System.out.println("\nPunto3: Ordena por precios");
        vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);
        System.out.println();

        garage.getVehiculos().stream()
                .sorted(Comparator.comparing(vehiculo -> vehiculo.getCosto())).forEach(value -> System.out.println(value));

        System.out.println();
        //ordena por marca y precio
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);


        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));

        System.out.println();
        System.out.println("\nPunto2: Ordenado por marca y precio");
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo);
        }


        System.out.println();
        System.out.println("Punto 5");


   /*     Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o
    igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.*/
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

        System.out.println("Sufrí!!! Fin");

        // ArrayList<int> listas = new ArrayList<>();
        int[] listas = {3, 5, 4, 1};

        List<Integer> nros = Arrays.asList(listas);





    }


    }

