package Ejercicio1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    private Object v1;

    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Fiesta","Ford",1000d);
        Vehiculo vehiculo2 = new Vehiculo("Focus","Ford",1200d);
        Vehiculo vehiculo3 = new Vehiculo("Explorer","Ford",2500d);
        Vehiculo vehiculo4 = new Vehiculo("Uno","Fiat",500d);
        Vehiculo vehiculo5 = new Vehiculo("Cronos","Fiat",1000d);
        Vehiculo vehiculo6 = new Vehiculo("Tornio","Fiat",1250d);
        Vehiculo vehiculo7 = new Vehiculo("Aveo","Chevrolet",1250d);
        Vehiculo vehiculo8 = new Vehiculo("Spin","Chevrolet",1250d);
        Vehiculo vehiculo9 = new Vehiculo("Corola","Toyota",2500d);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner","Toyota",3000d);
        Vehiculo vehiculo11 = new Vehiculo("Logan","Renault",950d);

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(vehiculo1);
        vehiculos.add(vehiculo2);
        vehiculos.add(vehiculo3);
        vehiculos.add(vehiculo4);
        vehiculos.add(vehiculo5);
        vehiculos.add(vehiculo6);
        vehiculos.add(vehiculo7);
        vehiculos.add(vehiculo8);
        vehiculos.add(vehiculo9);
        vehiculos.add(vehiculo10);
        vehiculos.add(vehiculo11);

        Garage garage = new Garage(1,vehiculos);

        System.out.println(garage);

        //vehiculos.sort(Comparator.comparing(Vehiculo::getCosto));

        //vehiculos.sort(Comparator.comparing((vehiculo)-> vehiculo.getCosto()));

        vehiculos.stream()
                .sorted(Comparator.comparing((vehiculo)-> vehiculo.getCosto()))
                .forEach(vehiculo-> System.out.println(vehiculo.toString()));
        System.out.println();
        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(vehiculo-> System.out.println(vehiculo.toString()));
    }
}
