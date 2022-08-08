package recapitulando;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        Vehiculo v1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo v2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo v3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo v4 = new Vehiculo("Uno", "Fiat", 500);
        List<Vehiculo> vehiculos = new ArrayList();

        vehiculos.add(v1);
        vehiculos.add(v2);
        vehiculos.add(v3);
        vehiculos.add(v4);

        Garaje garage = new Garaje(1, vehiculos);

        /*
        System.out.println(garage);

        garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getCosto));
        System.out.println(garage);
        garage.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        System.out.println(garage);
         */
        /*System.out.println("Costo menor a 1000:");
        garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto()< 1000.0)
                .forEach(System.out::println);

        System.out.println("Costo mayor o igual a 1000:");
        garage.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto()>= 1000.0)
                .forEach(System.out::println);*/
        System.out.println("Promedio:");
        System.out.println(garage.promedio());
    }
}
