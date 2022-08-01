package dakar;

public class Main {



    public static void main(String[] args) {



        Carrera carrera = new Carrera(300000, 1000, "Carrera dakar", 5 );
        carrera.darDeAltaAuto(200.0, 120.0, 30, "ABC 123" );
        carrera.darDeAltaMoto(150, 80, 20, "MOT 2324");
        carrera.darDeAltaAuto(500, 120.0, 30, "TEA 343" );
        carrera.darDeAltaMoto(150, 80, 20, "AAA 9999");

        System.out.println("");
        System.out.println("Vehiculos registrados");
        carrera.getListaVehiculos().forEach(System.out::println);

        System.out.println("");
        String vehiculoAEliminar = "MOT 2324";
        System.out.println("Eliminando vehiculo... " + vehiculoAEliminar);
        carrera.eliminarVehiculoConPatente(vehiculoAEliminar);

        System.out.println("");
        System.out.println("Socorrer");
        carrera.socorrerAuto("ABC 123");
        carrera.socorrerMoto("AAA 9999");

        System.out.println("");
        System.out.println("Calculando Vehículo agandor...");
        carrera.definirGanador();




    }
}
