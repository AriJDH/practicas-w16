package com.tomas.dakar;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,Vehiculo> listVehiculos = new HashMap<String,Vehiculo>();
        listVehiculos.put("12345",new Moto(15,20,12,"12345"));
        listVehiculos.put("45678",new Auto(45,23,12,"45678"));
        listVehiculos.put("98234",new Moto(12,22,42,"98234"));

        SocorristaMoto socorristaMoto= new SocorristaMoto(12,22,42,"2223445",90,3);
        SocorristaAuto socorristaAuto= new SocorristaAuto(12,22,42,"90w3342034",90,3);
        Carrera carrera = new Carrera(500,900,"asdasda",5,listVehiculos,socorristaAuto,socorristaMoto);

        //testeo de fallo de limite de vehiculos
        System.out.println("testeo de fallo de limite de vehiculos");
        carrera.darDeAltaAuto(12,12,12,"1234");
        carrera.darDeAltaAuto(12,12,12,"555");
        carrera.darDeAltaAuto(12,12,12,"3333");

        //testeo de chequeo de ganador
        System.out.println("testeo de chequeo de ganador");
        carrera.definirGanador();

        //testeo de socorrer
        System.out.println("testeo de socorrer");
        carrera.socorrerMoto("12345");
        carrera.socorrerAuto("45678");


    }
}
