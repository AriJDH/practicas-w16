package eip2vivo.Dakar;

public class Main {
    public static void main(String[] args) {

        Carrera carreaDeLaMuerte = new Carrera(200, 5000, "Death Race", 6);

        carreaDeLaMuerte.darDeAltaAuto(120, 10, 4,"WW1K");
        carreaDeLaMuerte.darDeAltaMoto(140, 15, 5,"WW2J");
        carreaDeLaMuerte.darDeAltaMoto(130, 16, 5,"W2KK");
        carreaDeLaMuerte.darDeAltaAuto(130, 12, 3,"WEDX");
        carreaDeLaMuerte.darDeAltaAuto(200, 12, 3,"YYYY");
        carreaDeLaMuerte.darDeAltaMoto(220, 12, 3,"XXXX");
        carreaDeLaMuerte.darDeAltaAuto(200, 12, 3,"ZZZZ");

        System.out.println(carreaDeLaMuerte);

        Vehiculo auto = carreaDeLaMuerte.getListaVehiculo().get(0);
        System.out.println(auto);


        carreaDeLaMuerte.eliminarVehiculo(auto);
        System.out.println("Se eliminó el primer vehiculo");
        System.out.println(carreaDeLaMuerte);

        System.out.println("Vehiculo eliminado por patente");
        carreaDeLaMuerte.eliminarVehiculoConPatente("WW2J");

        System.out.println(carreaDeLaMuerte);
        System.out.println("Ganador");
        carreaDeLaMuerte.getGanador();

        SocorristaMoto socorristaMoto = new SocorristaMoto(100,5,3, "SOS-MOTO");
        SoccoristaAuto soccoristaAuto = new SoccoristaAuto(100,5,3, "SOS-AUTO");

        carreaDeLaMuerte.setSoccoristaAuto(soccoristaAuto);
        carreaDeLaMuerte.setSocorristaMoto(socorristaMoto);

        carreaDeLaMuerte.socorrerAuto("YYYY");
        carreaDeLaMuerte.socorrerMoto("XXXX");

    }
}
