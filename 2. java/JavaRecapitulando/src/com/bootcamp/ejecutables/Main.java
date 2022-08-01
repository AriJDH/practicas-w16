package com.bootcamp.ejecutables;

import com.bootcamp.modelos.Vehiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
//    Vehiculo fordFiesta = new Vehiculo("Ford","Fiesta",1000);
//    Vehiculo fordFocus= new Vehiculo("Ford", "Focus", 1200);
//    Vehiculo fordExplorer= new Vehiculo("Ford", "Explorer", 2500);
//    Vehiculo fiatUno= new Vehiculo("Fiat", "Uno", 500);
//    Vehiculo fiatCronos= new Vehiculo("Fiat", "Cronos", 1000);
//    Vehiculo fiatTorino= new Vehiculo("Fiat", "Torino", 1250);
//    Vehiculo chevroletAveo= new Vehiculo("Chevrolet", "Aveo", 1250);
//    Vehiculo chevroletSpin= new Vehiculo("Chevrolet", "Spin", 2500);
//    Vehiculo toyotaCorola= new Vehiculo("Toyota", "Corola", 1200);
//    Vehiculo toyotaFortuner= new Vehiculo("Toyota", "Fortuner", 3000);
//    Vehiculo renaultLogan= new Vehiculo("Renault", "Logan", 950);


    List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

//    vehiculos.add(fordFiesta);
//    vehiculos.add(fordFocus);
//    vehiculos.add(fordExplorer);
//    vehiculos.add(fiatUno);
//    vehiculos.add(fiatCronos);
//    vehiculos.add(fiatTorino);
//    vehiculos.add(chevroletAveo);
//    vehiculos.add(chevroletSpin);
//    vehiculos.add(toyotaCorola);
//    vehiculos.add(toyotaFortuner);
//    vehiculos.add(renaultLogan);

    //Lista de vehiculos original
    System.out.println(vehiculos);

    //Ordenados por precio ascendente
    Comparator<Vehiculo> precioAsc = Comparator.comparing(Vehiculo::getCosto);
    List<Vehiculo> vehiculosPrecioAsc = vehiculos.stream().sorted(precioAsc).collect(Collectors.toList());
    System.out.println(vehiculosPrecioAsc);

    //Ordenados por precio descendente
    Comparator<Vehiculo> precioDesc = Comparator.comparing(Vehiculo::getCosto).reversed();
    List<Vehiculo> vehiculosPrecioDesc = vehiculos.stream().sorted(precioDesc).collect(Collectors.toList());
    System.out.println(vehiculosPrecioDesc);

    //Ordenados por modelo y despues por precio
    Comparator<Vehiculo> ordenByModeloPrecio = Comparator.comparing(Vehiculo::getModelo)
        .thenComparing(Vehiculo::getCosto);
    List<Vehiculo> vehiculosMarcaPrecio = vehiculos.stream().sorted(ordenByModeloPrecio).collect(Collectors.toList());
    System.out.println(vehiculosMarcaPrecio);

    //Obteniendo vehiculos con precio mayor no mayor a 1000
    List<Vehiculo> vehiculosMenores = vehiculos.stream()
        .filter(vehiculo -> vehiculo.getCosto() < 1000)
        .collect(Collectors.toList());
    System.out.println(vehiculosMenores);

    //Obteniendo los vehiculos con precio mayor o igual a 1000
    List<Vehiculo> vehiculoMayores = vehiculos.stream()
        .filter(vehiculo -> vehiculo.getCosto() > 1000)
        .collect(Collectors.toList());
    System.out.println(vehiculoMayores);

    //Promedio de precios de todos los vehiculos
//    Double promedio = vehiculos.stream()
//        .reduce(0.0, (subtotal, producto) -> subtotal + producto.getCosto(),Double::sum);
//    Double promedio3 = vehiculos.stream()
//        .mapToDouble(Vehiculo::getCosto)
//        .average()
//        .getAsDouble();
    Double promedio = vehiculos.stream()
        .mapToInt(vehiculo -> vehiculo.getCosto())
        .average()
        .getAsDouble();
    System.out.println(promedio);
  }
}
