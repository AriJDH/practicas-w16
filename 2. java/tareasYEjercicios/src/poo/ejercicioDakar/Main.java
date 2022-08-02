package poo.ejercicioDakar;

public class Main {

    public static void main(String[] args) {


        SocorristaAuto socorristaAuto = new SocorristaAuto(100D, 1000D, 40D, "1ASE345");
        SocorristaMoto socorristaMoto = new SocorristaMoto(80D, 500D, 20D, "09SDER");

        Carrera dakar = new Carrera(10000D, 8000D, "Dakar", 100,
                socorristaAuto, socorristaMoto);

        dakar.darDeAltaAuto(100D, 1000D, 40D, "AAAAAAA");
        dakar.darDeAltaAuto(200D, 100D, 40D, "BBBBBBBB");
        dakar.darDeAltaAuto(250D, 3000D, 40D, "CCCCCC");

        dakar.darDeAltaMoto(120D, 5000D, 40D, "DDDDDD");
        dakar.darDeAltaAuto(150D, 100D, 40D, "FFFFFF");
        dakar.darDeAltaMoto(110D, 1040D, 40D, "GGGGGGG");

        System.out.println(dakar);

        //No existe
        dakar.eliminarVehiculoConPatente("DDDD");

        dakar.eliminarVehiculoConPatente("AAAAAAA");
        System.out.println("Elimine vehiculo con patente 'AAAAAAA'" + dakar);

        dakar.eliminarVehiculo(dakar.buscarVehiculoPorPatente("FFFFFF"));
        System.out.println("Elimine vehiculo F" + dakar);

        System.out.println("Vehiculo ganador: " + dakar.definirGanador());

        dakar.socorrerAuto("BBBBBBBB");
        dakar.socorrerMoto("GGGGGGG");

    }
}
