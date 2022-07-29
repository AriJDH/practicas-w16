package ExerciseTwo.executable;

import java.util.List;
import java.util.stream.Collectors;

import ExerciseOne.actors.*;

/*
 * This contains solution for exercise 2, 3 4 and 5.
 */

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje("G001");
        garaje.addVehiculo(new Vehiculo("Ford", "Fiesta", 1000));
        garaje.addVehiculo(new Vehiculo("Ford", "Focus", 1200));
        garaje.addVehiculo(new Vehiculo("Ford", "Explorer", 2500));
        garaje.addVehiculo(new Vehiculo("Fiat", "Uno", 500));
        garaje.addVehiculo(new Vehiculo("Fiat", "Cronos", 1000));
        garaje.addVehiculo(new Vehiculo("Fiat", "Torino", 1250));
        garaje.addVehiculo(new Vehiculo("Chevrolet", "Aveo", 1250));
        garaje.addVehiculo(new Vehiculo("Chevrolet", "Spin", 2500));
        garaje.addVehiculo(new Vehiculo("Toyota", "Corola", 1200));
        garaje.addVehiculo(new Vehiculo("Toyota", "Fortuner", 3000));
        garaje.addVehiculo(new Vehiculo("Renault", "Logan", 950));


        //Exercise 3
        List<Vehiculo> sortedByPrice = garaje.getVehiculos().stream().sorted(
            (v1, v2) -> v1.getCosto() < v2.getCosto() ? -1 : 1
        ).collect(Collectors.toList());

        System.out.println("Vehiculos ordenados por precio:");
        sortedByPrice.forEach(System.out::println);

        //Exercise 4
        List<Vehiculo> sortedByBrandAndPrice = garaje.getVehiculos().stream().sorted(
            (v1, v2) -> {
                int result = v1.getMarca().compareTo(v2.getMarca());
                if (result == 0) {
                    result = v1.getCosto() < v2.getCosto() ? -1 : 1;
                }
                return result;
            }
        ).collect(Collectors.toList());

        System.out.println("\n\nVehiculos ordenados por marca y precio:");
        sortedByBrandAndPrice.forEach(System.out::println);

        // Exercise 5
        List<Vehiculo> filteredLowerEqualThan1000 = garaje.getVehiculos().stream().filter(
            v -> v.getCosto() <= 1000
        ).collect(Collectors.toList());

        List<Vehiculo> filteredGreaterEqualThan1000 = garaje.getVehiculos().stream().filter(
            v -> v.getCosto() >= 1000
        ).collect(Collectors.toList());

        double mean = garaje.getVehiculos().stream().mapToDouble(
            v -> v.getCosto()
        ).average().getAsDouble();

        System.out.println("\n\nVehiculos menores a 1000:");
        filteredLowerEqualThan1000.forEach(System.out::println);

        System.out.println("\n\nVehiculos mayores a 1000:");
        filteredGreaterEqualThan1000.forEach(System.out::println);

        System.out.printf("\n\nPromedio de costo: %.2f \n", mean);
        
    }
}
