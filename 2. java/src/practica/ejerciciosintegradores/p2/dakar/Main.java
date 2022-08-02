package practica.ejerciciosintegradores.p2.dakar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto autoUno = new Auto(200, 180, 90, "AUTO-UNO-1");
        Auto autoDos = new Auto(240, 160, 90, "AUTO-DOS-2");

        Moto motoUno = new Moto(300, 300, 180, "MOTO-UNO-1");
        Moto motoDos = new Moto(320, 280, 180, "MOTO-DOS-2");

        Auto autoTres = new Auto(220, 220, 180, "AUTO-TRES-3");
        Moto motoTres = new Moto(280, 300, 180, "MOTO-TRES-3");

        List<Vehiculo> vehiculosCarrera = new ArrayList<>(Arrays.asList(autoUno, autoDos, motoUno, motoDos));

        Carrera carrera = new Carrera(100.0, 10000, "Carrera de agosto", 5, vehiculosCarrera);

        carrera.darDeAltaAuto(220, 220, 180, "AUTO-TRES-3");
        carrera.darDeAltaMoto(280, 300, 180, "MOTO-TRES-3");

        carrera.socorrerAuto("AUTO-DOS-2");
        carrera.socorrerMoto("MOTO-UNO-1");

        System.out.println("El ganador es: " + carrera.obtenerGanador());
    }
}
