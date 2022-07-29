package recapitulandoJavaVivo;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage(1);

        garage.agregarVehiculos(new Vehiculo("Ford", "Fiesta", 1000));
        garage.agregarVehiculos(new Vehiculo("Ford", "Focus", 1200));
        garage.agregarVehiculos(new Vehiculo("Ford", "Explorer", 2500));
        garage.agregarVehiculos(new Vehiculo("Fiat", "Uno", 500));
        garage.agregarVehiculos(new Vehiculo("Fiat", "Cronos", 1000));
        garage.agregarVehiculos(new Vehiculo("Fiat", "Toro", 1250));
        garage.agregarVehiculos(new Vehiculo("Chevrolet", "Spin", 1250));
        garage.agregarVehiculos(new Vehiculo("Chevrolet", "Aveo", 2500));
        garage.agregarVehiculos(new Vehiculo("Toyota", "Corola", 1200));
        garage.agregarVehiculos(new Vehiculo("Toyota", "Fortuner", 3000));
        garage.agregarVehiculos(new Vehiculo("Renault", "Logan", 950));

        List ordenPorPrecio = garage.getVehiculos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).collect(Collectors.toList());

        System.out.println(ordenPorPrecio);

        List ordenDoble = garage.getVehiculos()
                .stream()
                .sorted( Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .collect(Collectors.toList());

        System.out.println(ordenDoble);

        List noMayorA1000 = garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());

        System.out.println(noMayorA1000);

        List mayorA1000 = garage.getVehiculos()
                .stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());

        System.out.println(mayorA1000);

        double promedioCostos = garage.getVehiculos()
                .stream()
                .mapToDouble(vehiculo -> vehiculo.getCosto())
                .average()
                .getAsDouble();

        System.out.println("El promedio de costos es de : $"+promedioCostos);


    }
}
