package ejerciciosIntegradoresP2Vivo.Dakar;

public class Main {

    public static void main(String[] args) {

        Carrera carrera = new Carrera(100,55.0,"Run",6);

        System.out.println("------Añadiendo vehiculos--------");
        carrera.darDeAltaAuto(150,30.2,20.8,"r123jo");
        carrera.darDeAltaAuto(140,60.3,20.1,"ve54iew");
        carrera.darDeAltaMoto(90,10.3,40.4,"qw34sdw");
        carrera.darDeAltaMoto(210,20.2,40.7,"3et5313");
        carrera.darDeAltaMoto(80,60.3,20.4,"fe2134");
        carrera.darDeAltaAuto(100,20.2,20.1,"as98zs");
        carrera.darDeAltaMoto(320,120,60.7,"98ert32");

        System.out.println("-----Eliminando vehiculos---------");

        carrera.eliminarVehiculo(new Auto(140,60.3,20.1,"ve54iew"));
        carrera.eliminarVehiculoConPatente("qw34sdw");

        System.out.println("---------Obteniendo ganador de la carrera--------");

        carrera.obtenerGanador();

        System.out.println("-----Socorriendo vehiculos-------");

        carrera.socorrerAuto("as98zs");
        carrera.socorrerMoto("3et5313");
    }
}
