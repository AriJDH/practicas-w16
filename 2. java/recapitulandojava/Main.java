package recapitulandojava;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;

public class Main {
    public static void main(String[] args) {

        Vehiculo auto1 = new Vehiculo("Fiesta","Ford", new BigDecimal("1000"));
        Vehiculo auto2 = new Vehiculo("Focus","Ford", new BigDecimal("1200"));
        Vehiculo auto3 = new Vehiculo("Explorer","Ford", new BigDecimal("2500"));
        Vehiculo auto4 = new Vehiculo("Uno","Fiat", new BigDecimal("500"));
        Vehiculo auto5 = new Vehiculo("Cronos","Fiat", new BigDecimal("1000"));
        Vehiculo auto6 = new Vehiculo("Torino","Fiat", new BigDecimal("1250"));
        Vehiculo auto7 = new Vehiculo("Aveo","Chevrolet", new BigDecimal("1250"));
        Vehiculo auto8 = new Vehiculo("Fortuner","Chevrolet", new BigDecimal("2500"));
        Vehiculo auto9 = new Vehiculo("Corola","Toyota", new BigDecimal("1200"));
        Vehiculo auto10 = new Vehiculo("Logan","Renault", new BigDecimal("3000"));
        Vehiculo auto11 = new Vehiculo("Fortuner","Toyota", new BigDecimal("950"));

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto1);
        vehiculos.add(auto2);
        vehiculos.add(auto3);
        vehiculos.add(auto4);
        vehiculos.add(auto5);
        vehiculos.add(auto6);
        vehiculos.add(auto7);
        vehiculos.add(auto8);
        vehiculos.add(auto9);
        vehiculos.add(auto10);
        vehiculos.add(auto11);

        Garage garaje = new Garage(1L,vehiculos);
        System.out.println("Precio");
        garaje.setVehiculos(garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList()));
        garaje.getVehiculos().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("Precio y marca");
        garaje.setVehiculos(garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca))
                .collect(Collectors.toList()));
        garaje.getVehiculos().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("Precios menores a 1000");

        List<Vehiculo> vehiculosMenoresA1000 = garaje.getVehiculos().stream()
                .filter(vehiculo-> vehiculo.getCosto().compareTo(new BigDecimal("1000"))==-1).collect(Collectors.toList());

        vehiculosMenoresA1000.stream().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        System.out.println("Precios mayores a 1000");
        List<Vehiculo> vehiculosMayoresA1000 = garaje.getVehiculos().stream()
                .filter(vehiculo-> vehiculo.getCosto().compareTo(new BigDecimal("1000"))>=0).collect(Collectors.toList());

        vehiculosMayoresA1000.stream().forEach(vehiculo -> System.out.println(vehiculo.toString()));

        BigDecimal suma=garaje.getVehiculos().stream()
                .map(vehiculo -> vehiculo.getCosto())
                .reduce(ZERO,BigDecimal::add);
        System.out.println("El total del costo de los vehiculos es: "+suma);
        System.out.println("El promerdio del costo de los vehiculos es: "+suma.divide(valueOf(garaje.getVehiculos().size()),RoundingMode.CEILING));
    }
}




