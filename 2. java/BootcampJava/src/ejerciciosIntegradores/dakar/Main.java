package ejerciciosIntegradores.dakar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Carrera carrera = new Carrera(10f,5000f,"Ca k rrera",10,vehiculos);
        carrera.darDeAltaAuto(5,5f,5f,"AABBCC");
        carrera.darDeAltaAuto(100,100f,180f,"DDEEFF");
        carrera.darDeAltaAuto(20,10f,180f,"AAAAAA");
        carrera.darDeAltaMoto(20,10f,180f,"IIIIII");

        carrera.socorrerAuto("AABBCC");
        carrera.socorrerMoto("IIIIII");

        carrera.eliminarVehiculoConPatente("AAAAAA");

        System.out.println(carrera.obtGanador());

    }
}

