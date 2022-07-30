package Ej_recapitulando_java;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("fiesta", "ford", 1000.0));
        vehiculos.add(new Vehiculo("focus", "ford", 1200.0));
        vehiculos.add(new Vehiculo("explorer", "ford", 2500.0));
        vehiculos.add(new Vehiculo("uno", "fiat", 1000.0));
        vehiculos.add(new Vehiculo("cronos", "fiat", 1000.0));
        vehiculos.add(new Vehiculo("aveo", "chevrolet", 1250.0));
        vehiculos.add(new Vehiculo("spin", "chevrolet", 2500.0));
        vehiculos.add(new Vehiculo("fortuner", "toyota", 1200.0));
        vehiculos.add(new Vehiculo("logan", "renault", 950.0));

        Garage garage = new Garage(1, vehiculos);

        //Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.
        System.out.println("Ordenado por marca");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getCosto)).forEach(System.out::println);

        //De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
        System.out.println();
        System.out.println("Ordenado por marca");
        vehiculos.stream().sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);//.reversed() para q sea al reves

        //Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios mayor o igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.
        System.out.println();
        System.out.println("vehiculos menor= a 1000");
        vehiculos.stream().filter(v -> v.getCosto() <= 1000).forEach(System.out::println);
        System.out.println();
        System.out.println("vehiculos mayor= a 1000");
        vehiculos.stream().filter(v -> v.getCosto() >= 1000).forEach(System.out::println);
        System.out.println();
        System.out.println("promedio total");
        System.out.println(vehiculos.stream().mapToDouble(v -> v.getCosto()).average().getAsDouble());

        //IMPORTANTE siempre hacer override en los metodos toString para que se vean bien los objetos,
        // y pueda usar los strems etc que sino tira error, y de paso se puede hacer ttodo mas facil y no como esta arriba


    }
}
