package EjerciciosIntegradores_Java.Ejercicio_Dakar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Creo vehiculos socorristas de autos y de motos
        SocorristaAuto soc1 = new SocorristaAuto(150.0, 30.0, 40.0, "GHI 789", 700.0, 4);
        SocorristaMoto soc2 = new SocorristaMoto(100.0, 20.0, 30.0, "JKL 111", 200.0, 2);

        //Creo la carrera
        Carrera carrera = new Carrera(44.1, 200000.0, "Dakar Argentina", 4, soc1, soc2);
        //Agrego los vehiculos a la carrera
        carrera.darDeAltaAuto(300.0, 50.0, 90.0, "ABC 123");
        carrera.darDeAltaMoto(200.0, 30.0, 75.0, "DEF 456");
        carrera.darDeAltaAuto(300.0, 50.0, 90.0, "ABD 123");
        carrera.darDeAltaMoto(200.0, 30.0, 75.0, "DEG 456");

        //Elimino un vehiculo por objeto (con error)
        carrera.eliminarVehiculo(new Auto(300.0, 50.0, 90.0, "ABZ 123"));
        //Elimino un vehiculo por objeto (sin error)
        carrera.eliminarVehiculo(new Auto(300.0, 50.0, 90.0, "ABC 123"));
        //Elimino un vehiculo por patente (con error)
        carrera.eliminarVehiculoConPatente("DEZ 456");
        //Elimino un vehiculo por patente (sin error)
        carrera.eliminarVehiculoConPatente("DEG 456");

        //Defino el ganador de la carrera
        carrera.definirGanador();

        //Socorro auto
        carrera.socorrerAuto("ABC 123");
        //Socorro moto
        carrera .socorrerMoto("DEF 456");

    }
}
