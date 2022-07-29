package com.tomas.vehiculos;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {


    private static final BigDecimal ZERO = new BigDecimal("0");

    public static void main(String[] args) {

        Vehiculo vehiculoUno = new Vehiculo("Fiesta","Ford", new BigDecimal(1000));
        Vehiculo vehiculoDos = new Vehiculo("Focus","Ford", new BigDecimal(1200));
        Vehiculo vehiculoTres = new Vehiculo("Explorer","Ford", new BigDecimal(2500));
        Vehiculo vehiculoCuatro = new Vehiculo("Uno","Fiat", new BigDecimal(500));
        Vehiculo vehiculoCinco = new Vehiculo("Cronos","Fiat", new BigDecimal(1000));
        Vehiculo vehiculoSeis = new Vehiculo("Torino","Fiat", new BigDecimal(1250));
        Vehiculo vehiculoSiete = new Vehiculo("Aveo","Chevrolet", new BigDecimal(1250));
        Vehiculo vehiculoOcho = new Vehiculo("Fortuner","Chevrolet", new BigDecimal(2500));
        Vehiculo vehiculoNueve = new Vehiculo("Corola","Toyota", new BigDecimal(1200));
        Vehiculo vehiculoDiez = new Vehiculo("Logan","Renault", new BigDecimal(3000));
        Vehiculo vehiculoOnce = new Vehiculo("Fortuner","Toyota", new BigDecimal(950));

        List<Vehiculo> objVehiculo = new ArrayList<>();
        objVehiculo.add(vehiculoUno);
        objVehiculo.add(vehiculoDos);
        objVehiculo.add(vehiculoTres);
        objVehiculo.add(vehiculoCuatro);
        objVehiculo.add(vehiculoCinco);
        objVehiculo.add(vehiculoSeis);
        objVehiculo.add(vehiculoSiete);
        objVehiculo.add(vehiculoOcho);
        objVehiculo.add(vehiculoNueve);
        objVehiculo.add(vehiculoDiez);
        objVehiculo.add(vehiculoOnce);

        Garaje objGaraje = new Garaje(1, objVehiculo);


        System.out.println("----------------------------------------------");
        System.out.println("Autos ordenados por precio de menor a mayor");
        System.out.println("----------------------------------------------");

        objGaraje.getListaVehiculo().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList()).forEach(recorrido ->
                System.out.println(recorrido.toString())
        );

        System.out.println();
        System.out.println();

        System.out.println("-------------------------------------------------------");
        System.out.println("Autos ordenados por marca y precio ");
        System.out.println("-------------------------------------------------------");

        objGaraje.getListaVehiculo().stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .sorted(Comparator.comparing(Vehiculo::getMarca))
                .collect(Collectors.toList()).forEach(recorrido ->
                System.out.println(recorrido.toString())
        );

        System.out.println();
        System.out.println();

        System.out.println("-------------------------------------------------------");
        System.out.println("Autos con valor menor a 1000");
        System.out.println("-------------------------------------------------------");

        objGaraje.getListaVehiculo().stream()
                .filter(costo->costo.getCosto().compareTo(new BigDecimal("1000"))==-1)
                .collect(Collectors.toList()).forEach(recorrido ->
                System.out.println(recorrido.toString()));


        System.out.println();
        System.out.println();

        System.out.println("-------------------------------------------------------");
        System.out.println("Autos con valor mayor o igual a 1000");
        System.out.println("-------------------------------------------------------");

        objGaraje.getListaVehiculo().stream()
                .filter(costo->costo.getCosto().compareTo(new BigDecimal("1000"))==0 || costo.getCosto().compareTo(new BigDecimal("1000"))==1)
                .collect(Collectors.toList()).forEach(recorrido ->
                System.out.println(recorrido.toString()));


        System.out.println();
        System.out.println();

        System.out.println("----------------------------");
        System.out.println("Promedio de precios");
        System.out.println("----------------------------");
        BigDecimal suma = objGaraje.getListaVehiculo()
                .stream()
                .map(costo->costo.getCosto())
                .reduce(ZERO,BigDecimal::add);

        BigDecimal divisor = BigDecimal.valueOf(objGaraje.getListaVehiculo().size());
        System.out.println(suma.divide(divisor, RoundingMode.FLOOR));


    }
}
