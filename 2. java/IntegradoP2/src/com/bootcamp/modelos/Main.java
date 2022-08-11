package com.bootcamp.modelos;

public class Main {
  public static void main(String[] args) {

    Carrera carrera = new Carrera(300.0, 1000.1, "Carrea de la muerte", 4);

    System.out.println("Se agregan vehiculos a la carrera");
    carrera.darAltaAuto(60.0, 20.0, 30.0, "#DG!##G");
    carrera.darAltaAuto(53.2, 43.0, 45.9, "#GG#&&%");
    carrera.darAltaMoto(90.3, 79.4,90.3, "#G(%F*$");
    carrera.darAltaMoto(80.6, 87.8, 80.4, "#DY&$!B");
    carrera.darAltaMoto(84.6, 77.8, 100.4, "#DY&$!C");

    System.out.println("Lista de vehiculos inscritos");
    System.out.println(carrera.getListaVehiculos());


    System.out.println("Eliminando vehiculos");
    carrera.eliminarVehiculo(carrera.getListaVehiculos().get(0));
    carrera.eliminarVehiculoConPatente("#GG#&&%");
    System.out.println(carrera.getListaVehiculos().size());

    System.out.println("Ganarador de la carrera");
    System.out.println(carrera.definirGanador());


  }
}
