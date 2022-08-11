package integradores.integrador2.dakar;

public class Main {

    public static void main(String[] args) {
        Carrera carrera = new Carrera(1500, 1500.0, "Carrera1", 5,
                new SocorristaAuto(100, 150, 90, "aaa1234"),
                new SocorristaMoto(80, 100, 120, "bbb5678"));

        carrera.darDeAltaAuto(200, 120, 100, "abc1234");
        carrera.darDeAltaAuto(220, 90, 90, "cdf5678");
        carrera.darDeAltaAuto(180, 100, 100, "abc1111");
        carrera.darDeAltaMoto(70, 50, 120, "bbb2222");
        carrera.darDeAltaMoto(80, 60, 100, "ccc3456");
        carrera.darDeAltaMoto(110, 90, 130, "fgh1234");

        carrera.eliminarVehiculoConPatente("cdf5678");
        carrera.getVehiculos().stream().forEach(System.out::println);

        System.out.println("Ganador = " + carrera.obtenerGanador());
    }
}
