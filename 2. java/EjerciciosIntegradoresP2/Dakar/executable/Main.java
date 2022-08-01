package EjerciciosIntegradoresP2.Dakar.executable;

import EjerciciosIntegradoresP2.Dakar.actors.*;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(250, 100, "Carrera 1", 3);

        carrera.darDeAltaMoto(10, 10, 10, "AAA111");
        carrera.darDeAltaMoto(30, 10, 10, "BBB222");
        carrera.darDeAltaAuto(30, 10, 10, "CCC333");

        System.out.println(carrera.getGanador());

        carrera.socorrerAuto("CCC333");
    }
}
