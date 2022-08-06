package RecapitulandoJavaVivo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford","Fiesta",1000));
        vehiculos.add(new Vehiculo("Ford","Focus",1200));
        vehiculos.add(new Vehiculo("Ford","Explorer",2500));
        vehiculos.add(new Vehiculo("Fiat","Uno",500));
        vehiculos.add(new Vehiculo("Fiat","Cronos",1000));
        vehiculos.add(new Vehiculo("Fiat","Torino",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Aveo",1250));
        vehiculos.add(new Vehiculo("Chevrolet","Spin",2500));
        vehiculos.add(new Vehiculo("Toyota","Corola",1200));
        vehiculos.add(new Vehiculo("Toyota","Fortuner",3000));
        vehiculos.add(new Vehiculo("Renault","Logan",950));

        Garage garage = new Garage(1,vehiculos);

        System.out.println("Lista ordenada por precio de menor a mayor");
        vehiculos.stream().sorted((a,b)->a.getCosto().compareTo(b.getCosto())).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("Lista ordenada por precio y marca");
        vehiculos.stream().sorted((a,b)->a.getMarca().compareTo(b.getMarca()))
                .collect(Collectors.toList()).stream()
                .sorted((a,b)->a.getCosto().compareTo(b.getCosto())).collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Lista de vehiculos con precio no mayor a 1000");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()<1000).forEach(System.out::println);
        System.out.println();

        System.out.println("Lista de vehiculos con precio mayor o igual a 1000");
        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto()>=1000).forEach(System.out::println);
        System.out.println();

        System.out.println("Promedio total");
        double promedio = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().getAsDouble();
        System.out.println(promedio);
    }
}
