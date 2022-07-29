package Streams;

import Streams.models.Garaje;
import Streams.models.Vehiculo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.*;

public class Main {
    public static void main(String[]args){
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

        List <Vehiculo> vehiculos = new LinkedList<Vehiculo>();

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


        Garaje garaje = new Garaje(0L,vehiculos);

        garaje.getAutos().stream().forEach(v-> System.out.println(v.toString()));

        garaje.setAutos(garaje.getAutos().stream().sorted(Comparator.comparing(Vehiculo::getCosto)).collect(Collectors.toList()));

        System.out.println("Autos ordenados por precio");

        garaje.getAutos().stream().forEach(v-> System.out.println(v.toString()));

        System.out.println("Autos ordenados por precio y marca");

        garaje.setAutos(garaje.getAutos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto).thenComparing(Vehiculo::getMarca))
                .collect(Collectors.toList()));

        garaje.getAutos().stream().forEach(v-> System.out.println(v.toString()));


        System.out.println("Autos con valor menor a 1000");

        List<Vehiculo> vehiculosMenosAMil=garaje.getAutos()
                .stream()
                .filter(a->a.getCosto().compareTo(new BigDecimal("1000"))==-1)
                .collect(Collectors.toList());


        vehiculosMenosAMil.stream().forEach(v-> System.out.println(v.toString()));

        System.out.println("Autos con valor mayor a 1000");


        List<Vehiculo> vehiculosMayorOIgualAMil=garaje.getAutos()
                .stream()
                .filter(a->a.getCosto().compareTo(new BigDecimal("1000"))==0||a.getCosto().compareTo(new BigDecimal("1000"))==1)
                .collect(Collectors.toList());

        vehiculosMayorOIgualAMil.stream().forEach(v-> System.out.println(v.toString()));

        System.out.println("Promedio de precios");




        BigDecimal sum = garaje.getAutos().stream().map(v->v.getCosto()).reduce(ZERO,BigDecimal::add);

        BigDecimal divisor = valueOf(garaje.getAutos().size());

        System.out.println(sum.divide(divisor,
                RoundingMode.FLOOR));
    }
}
