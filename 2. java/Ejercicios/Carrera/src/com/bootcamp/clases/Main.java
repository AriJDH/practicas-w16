package com.bootcamp.clases;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1= new Auto(80d,12d,45,"SCK1010");
        Vehiculo vehiculo2= new Auto(1d,17d,30,"CBB3210");
        Vehiculo vehiculo3= new Auto(75d,10d,45,"NVC8399");
        Vehiculo vehiculo4= new Auto(11d,12d,45,"BJD8367");
        List<Vehiculo> listVehiculos= new ArrayList<>();
        listVehiculos.add(vehiculo1);
        listVehiculos.add(vehiculo2);
        listVehiculos.add(vehiculo3);
        listVehiculos.add(vehiculo4);
        SocorristaAuto socorristaAuto= new SocorristaAuto(80d,12d,45,"YUT8378",1000d,4);
        SocorristaMoto socorristaMoto= new SocorristaMoto(80d,12d,45,"JNE3528",1000d,4);

        Carrera carrera = new Carrera(2000d,3000d,"Carrea Pepito", 5,listVehiculos,socorristaAuto,socorristaMoto);

        System.out.println("El vehiculo ganador es"+carrera.definirGanador());
        carrera.socorrerAuto("BJD8367");
        carrera.darDeAltaAuto(100d,20d,45,"NHG3280");
        System.out.println("El vehiculo ganador es"+carrera.definirGanador());


        //modificar metodo de dar de alta vehiculo para agregar a la lista general

    }
}
