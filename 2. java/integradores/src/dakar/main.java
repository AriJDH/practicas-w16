package dakar;

import dakar.domain.Auto;
import dakar.domain.Carrera;
import dakar.domain.Moto;
import dakar.domain.Vehiculo;

public class main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(22,4000,"GP de hungria",20);
        carrera.darDeAltaAuto(150,22.1,210,"djk117");
        carrera.darDeAltaAuto(100,22.1,70,"dj117KR");


        System.out.println("El ganador es: "+carrera.getListaDeVehiculos());

        carrera.socorrerAuto("djk117");

    }
}
