package RecapitulandoJava;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    Vehiculo vehiculo = new Vehiculo("Ford", "Fiesta", 1000);

    public static void main(String[] args) {

        List<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();

        listaVehiculo.add(new Vehiculo("Ford", "Fiesta", 1000));
        listaVehiculo.add(new Vehiculo("Ford", "Focus", 1200));
        listaVehiculo.add(new Vehiculo("Ford", "Explorer", 2500));
        listaVehiculo.add(new Vehiculo("Fiat", "Uno", 500));
        listaVehiculo.add(new Vehiculo("Fiat", "Cronos", 1000));
        listaVehiculo.add(new Vehiculo("Fiat", "Torino", 1250));
        listaVehiculo.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        listaVehiculo.add(new Vehiculo("Chevrolet", "Spin", 2500));
        listaVehiculo.add(new Vehiculo("Toyota", "Corola", 1200));
        listaVehiculo.add(new Vehiculo("Toyota", "Fortuner", 3000));
        listaVehiculo.add(new Vehiculo("Renault", "Logan", 950));
        System.out.println("----------------------------------------------------------");
        System.out.println("Ejercicio 3");
        Garage garaje = new Garage(1, listaVehiculo);
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + " Modelo: " + vehiculo.getModelo() + " Costo: " + vehiculo.getCosto()));
        System.out.println("----------------------------------------------------------");
        System.out.println("Ejercicio 4");
        garaje.vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + " Modelo: " + vehiculo.getModelo() + " Costo: " + vehiculo.getCosto()));

        System.out.println("----------------------------------------------------------");
        System.out.println("Ejercicio 5");
        System.out.println("precio no mayor a 1000"+"\n");
        listaVehiculo.stream().filter(val -> val.getCosto() <1000).forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + " Modelo: " + vehiculo.getModelo() + " Costo: " + vehiculo.getCosto()));
        System.out.println("----------------------------------------------------------");
        System.out.println("precio mayor= a 1000"+"\n");
        listaVehiculo.stream().filter(val -> val.getCosto() >=1000).forEach(vehiculo -> System.out.println("Marca: " + vehiculo.getMarca() + " Modelo: " + vehiculo.getModelo() + " Costo: " + vehiculo.getCosto()));
        System.out.println("----------------------------------------------------------");
        OptionalDouble promedio =listaVehiculo.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average();
        System.out.println("Promedio de precios: "+promedio.getAsDouble());


    }
}
