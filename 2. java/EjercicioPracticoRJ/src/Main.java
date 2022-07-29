import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;


public class Main {
    public static void main(String[] args) {

        List<Vehiculo> listaVehiculos = new ArrayList<>();

        listaVehiculos.add(new Vehiculo("Fiesta",1000,"Ford"));
        listaVehiculos.add(new Vehiculo("Focus",1200,"Ford"));
        listaVehiculos.add(new Vehiculo("Explorer",2500,"Ford"));
        listaVehiculos.add(new Vehiculo("Uno",500,"Fiat"));
        listaVehiculos.add(new Vehiculo("Cronos",1000,"Fiat"));
        listaVehiculos.add(new Vehiculo("Torino",1250,"Fiat"));
        listaVehiculos.add(new Vehiculo("Aveo",1250,"Chevrolet"));
        listaVehiculos.add(new Vehiculo("Spin",2500,"Chevrolet"));
        listaVehiculos.add(new Vehiculo("Corolla",1200,"Toyota"));
        listaVehiculos.add(new Vehiculo("Fortuner",3000,"Toyota"));
        listaVehiculos.add(new Vehiculo("Logan",950,"Renault"));

        Garaje garaje = new Garaje(1,listaVehiculos);

        //ejercicio 3
        garaje.getListaVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo));

        //ejercicio4
        System.out.println("Ejercicio 4");
        garaje.getListaVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(vehiculo -> System.out.println(vehiculo));

        //ejercicio5
        System.out.println("Ejercicio 5");
        System.out.println("menor a 1000");
         garaje.getListaVehiculos()
                .stream()
                .filter(x->x.getCosto()<1000)
                 .forEach(System.out::println);
        System.out.println("mayor igual a 1000");
        garaje.getListaVehiculos()
                .stream()
                .filter(x->x.getCosto()>=1000)
                .forEach(System.out::println);

        OptionalDouble average = garaje.getListaVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average();
        System.out.println("Average is = " + average.getAsDouble());






    }


}
