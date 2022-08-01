package ejercicio2.main;

import ejercicio2.clases.*;

public class Main {
    public static void main(String[] args) {
        //Crear carrera
        Carrera carrera = new Carrera(120, 23000, "Carrera rápida", 5);
        //AutoSocorrista
        SocorristaAuto socorristaAuto = new SocorristaAuto(210, 3, 45, "SocorroAuto");
        carrera.setSocorristaAuto(socorristaAuto);
        //MotoSocorrista
        SocorristaMoto socorristaMoto = new SocorristaMoto(210, 10, 35, "SocorroMoto");
        carrera.setSocorristaMoto(socorristaMoto);

        carrera.darDeAltaAuto(210, 6, 49, "PAT111");
        carrera.darDeAltaAuto(240, 5, 45, "PAT222");
        carrera.darDeAltaAuto(232, 6, 65, "PAT333");
        carrera.darDeAltaAuto(220, 10, 50, "PAT444");

        carrera.darDeAltaMoto(300, 7, 90, "MOT111");
        carrera.darDeAltaMoto(290, 8, 40, "MOT222");

        System.out.println(carrera.getListaDeVehiculos());

        carrera.socorrerAuto("PAT111");
        carrera.socorrerMoto("MOT111");
        carrera.socorrerMoto("PAT222");

        Vehiculo ganador = carrera.definirGanador();

        carrera.eliminarVehiculo(ganador);
        carrera.eliminarVehiculoConPatente("MOT222");
        carrera.eliminarVehiculoConPatente("PAT111");
    }
}
