package praticesDakar;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Auto auto2 = new Auto(40,70,90, "LHIINEXI");

        List<Vehiculo> vehiculoList = new ArrayList<>();
        Carrera carrera = new Carrera(100, 3000, "Carrera1",3, vehiculoList);

        carrera.darDeAltaAuto(50,60,90, "FKEVEL");
        carrera.darDeAltaMoto(40,70,90, "LWIINXI");
        carrera.darDeAltaMoto(40,70,90, "LHIINEXI");

        carrera.eliminarVehiculo(auto2);
        carrera.eliminarVehiculoConPatente("LHIINEXI");

        carrera.ganadorCarrera();

        carrera.socorrerAuto("FKEVEL");
        carrera.socorrerMoto("LWIINXI");

    }
}
