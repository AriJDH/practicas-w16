package integrador.p2_dakar;

import integrador.p2_dakar.model.*;

public class Main {
    public static void main(String[] args) {
        SocorristaAuto socorristaAuto = new SocorristaAuto(200.0, 20.5, 90.0, "SOS1", 400.0, 4);
        SocorristaMoto socorristaMoto = new SocorristaMoto(200.0, 20.5, 90.0, "SOS2", 400.0, 4);

        Carrera carrera1 = new Carrera(400.0, 2000.0, "DAKAR", 10, socorristaAuto, socorristaMoto);
        carrera1.darDeAltaAuto(224.0, 20.5, 90.0, "ABC1");
        carrera1.darDeAltaAuto(242.0, 20.5, 90.0, "ABC3");
        carrera1.darDeAltaAuto(223.0, 20.5, 90.0, "ABC4");
        carrera1.darDeAltaAuto(220.0, 20.5, 90.0, "ABC5");
        carrera1.darDeAltaMoto(202.0, 20.5, 90.0, "ABC2");
        carrera1.darDeAltaMoto(201.0, 20.5, 90.0, "ABC6");

        carrera1.eliminarVehiculoConPatente("ABC5");
        System.out.println("🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳");
        System.out.printf("Ganador: %s", carrera1.getGanador());
        System.out.println("🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳🥳");
    }
}
