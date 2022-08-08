package vehiculos;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Ejercicio > Modulo 5: Java > RecapitulandoJava-VIVO
 * ESTADO: Finalizado (falta revision).
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaDeVehiculos = new ArrayList(Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

        Garage garage = new Garage(1, listaDeVehiculos);

        // Ordenar vehiculos por costo de menor a mayor
        listaDeVehiculos.sort(Comparator.comparing(Vehiculo::getCosto));

        // Ordenar vehiculos por costo de menor a mayor
        listaDeVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        // Ordenar vehiculos por marca y despues por costo
        listaDeVehiculos.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        listaDeVehiculos.forEach(System.out::println);

        // Ordenar vehiculos por marca y despues por costo (segunda forma)
        listaDeVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        // Filtras los vehiculos cuyo costo es menor o igual a 1000 (devolves otra lista)
        List<Vehiculo> listaFiltrada = listaDeVehiculos.stream()
                                            .filter((vehiculo) -> vehiculo.getCosto() <= 1000)
                                            .collect(Collectors.toList());
        listaFiltrada.forEach(System.out::println);

        // Filtras vehiculos cuyo costo es mayor o igual a 1000 (devolves otra lista)
        List<Vehiculo> listaFiltrada2 = listaDeVehiculos.stream()
                .filter((vehiculo) -> vehiculo.getCosto() >= 1000 )
                .collect(Collectors.toList());
        listaFiltrada.forEach(System.out::println);

        // Calculando el promedio de costos de todos los vehiculos
        System.out.println(listaDeVehiculos.stream().mapToDouble((vehiculo) -> {
            return vehiculo.getCosto();
        }).average().getAsDouble());
    }
}
