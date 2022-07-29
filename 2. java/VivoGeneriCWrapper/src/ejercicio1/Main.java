package ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();
        listaVehiculo.add(new Vehiculo("Ford","Fiesta",1000));
        listaVehiculo.add(new Vehiculo("Ford","Focus",1200));
        listaVehiculo.add(new Vehiculo("Ford","Explorer",2500));
        listaVehiculo.add(new Vehiculo("Fiat","Uno",500));
        listaVehiculo.add(new Vehiculo("Fiat","Cronos",1000));
        listaVehiculo.add(new Vehiculo("Fiat","Torino",1250));
        listaVehiculo.add(new Vehiculo("Chevrolet","Aveo",1250));
        listaVehiculo.add(new Vehiculo("Chevrolet","Spin",2500));
        listaVehiculo.add(new Vehiculo("Toyota","Corola",1200));
        listaVehiculo.add(new Vehiculo("Toyota","Fortuner",3000));
        listaVehiculo.add(new Vehiculo("Renault","Logan",950));

        Garaje garaje = new Garaje(1,listaVehiculo);
        //ejercicio3
        System.out.println("Ejercicio 3");
        garaje.getListaVehiculo()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo));

        //
        System.out.println("Ejercicio 4");
        garaje.getListaVehiculo()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo));

        //Ejercicio 5
        System.out.println("Ejercicio 5");
        System.out.println("Menor o igual a 1000");
        garaje.getListaVehiculo()
                .stream()
                .filter(x->x.getCosto()<=1000)
                .forEach(System.out::println);
        System.out.println("Mayor o igual a 1000");
        garaje.getListaVehiculo()
                .stream()
                .filter(x->x.getCosto()>=1000)
                .forEach(System.out::println);

        OptionalDouble average =garaje.getListaVehiculo()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average();

        System.out.println("Average is " + average.getAsDouble());
    }
}
