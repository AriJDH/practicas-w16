import Vehiculos.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Vehículos que participan en la carrera
        List<Vehiculo> listaParticipantes = new ArrayList<>(Arrays.asList(
                new Auto(200, 400, 6, "PJHJ-98"),
                new Auto(220, 480, 5, "LJUT-64"),
                new Auto(180, 300, 7, "LOIY-43"),
                new Auto(190, 650, 3, "VFDC-76"),
                new Moto(198, 900, 10, "LUTB-56"),
                new Moto(210, 860, 9, "MNDC-65"),
                new Moto(200, 400, 8, "VCED-05")
        ));

        //Vehículos socorristas
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        //Carrera
        Carrera carrera = new Carrera(3.78, 40000000, "Gran Premio de Melbourne",
                20, listaParticipantes, socorristaAuto, socorristaMoto);

        //Impresión de participantes
        System.out.println("Listado de participantes: ");
        for (Vehiculo participantes : listaParticipantes){
            System.out.println(participantes.getPatente());
        }

        //Se agrega un auto a la carrera
        carrera.darDeAltaAuto(225, 40, 8, "KIXS-23");
        //Se agrega una moto a la carrera
        carrera.darDeAltaMoto(186, 80, 7, "POMN-43");

        //Se elimina un auto haciendo referencia a un auto que existe dentro del array de Participantes
        Auto autoParaEliminar = new Auto(200, 40, 6, "PJHJ-98");
        carrera.eliminarVehiculo(autoParaEliminar);

        //Se elimina un vehículo utilizando la patente como criterio de búsqueda
        carrera.eliminarVehiculoConPatente("LJUT-64");

        //Impresión de lista de participantes modificada
        System.out.println();
        System.out.println("Nuevo listado de participantes: ");
        for (Vehiculo participantes : listaParticipantes){
            System.out.println(participantes.getPatente());
        }

        //Ganador de la carrera
        System.out.println();
        System.out.println("El vehiculo ganador de la carrera es: " + carrera.definirGanador().getPatente());

        //Socorristas ayudan a un auto y una moto según su patente
        System.out.println();
        carrera.socorrerMoto("POMN-43");
        carrera.socorrerAuto("KIXS-23");

    }
}
