package dakar;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500,15000,"Las 500 de Indianapolis", 6);
        Vehiculo vehiculo = new Auto(120,34,50,"VET777");
        Vehiculo vehiculo2 = new Moto(130,45,22,"DNG86e");
        System.out.println("---------------------------------------------------------------------------");
        carrera.darDeAltaAuto(120,34,50,"VET777");
        carrera.darDeAltaAuto(119,39,60,"MAE410");
        carrera.darDeAltaAuto(118,40,12,"SIJ934");
        carrera.darDeAltaAuto(115,50,45,"GMD123");
        System.out.println("---------------------------------------------------------------------------");
        carrera.darDeAltaMoto(130,45,22,"DNG86C");
        carrera.darDeAltaMoto(132,44,29,"ZRP49D");
        carrera.darDeAltaMoto(133,43,34,"GDY73F");
        carrera.darDeAltaMoto(134,42,33,"SFE43X");
        System.out.println("---------------------------------------------------------------------------");
        carrera.eliminarVehiculo(vehiculo);
        carrera.eliminarVehiculo(vehiculo2);
        carrera.eliminarVehiculoConPatente("SIJ934");
        carrera.eliminarVehiculoConPatente("ASD123");
        System.out.println("---------------------------------------------------------------------------");

        carrera.socorrerAuto("MAE310");
        carrera.socorrerMoto("DNG86C");
        carrera.socorrerMoto("ASD123");
        carrera.socorrerAuto("GMD123");
        System.out.println("");
        System.out.println("#################################################");
        System.out.println("");
        carrera.ganador();
        System.out.println("");
        System.out.println("#################################################");


    }
}
