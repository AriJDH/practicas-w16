package generics_wrapper.ejercicio_1y2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args){

        List<Vehiculo> vehiculoList = new ArrayList<>();
        Vehiculo fiesta = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo focus = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo torino = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo uno = new Vehiculo("Uno", "Fiat", 500);

        vehiculoList.add(fiesta);
        vehiculoList.add(focus);
        vehiculoList.add(torino);
        vehiculoList.add(uno);

        Garaje garaje = new Garaje();
        garaje.setId(1L);
        garaje.setVehiculoList(vehiculoList);

        //Ejercicio 3
        System.out.println("---Ejercicio 3---");
        vehiculoList.sort(Comparator.comparing(Vehiculo::getCosto));
        vehiculoList.forEach(System.out::println);
        //Ejercicio 4
        System.out.println("\n---Ejercicio 4---");
        vehiculoList.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        vehiculoList.forEach(System.out::println);
        //Ejercicio 5
        System.out.println("\n---Ejercicio 5---");
        System.out.println("\nCosto Menor a 1000");
        vehiculoList.stream()
                .filter(v -> v.getCosto() < 1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("\nCosto Mayor o Igual 1000");
        vehiculoList.stream()
                .filter(v -> v.getCosto() >= 1000)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("\nPromedio de Costos");
        System.out.println(garaje.calculateAverage());
    }


}
