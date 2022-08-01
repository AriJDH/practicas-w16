public class Main {
    public static void main(String[] args) {

        Auto auto = new Auto(300.0, 100.0, 75.0, "AA12");
        Moto moto = new Moto(150.0, 66.6, 34.2, "MO32");
        Moto moto2 = new Moto(350.0, 7.3, 150.0, "ONE 234");

        Carrera carrera = new Carrera(174.5, 1000.0, "Gran Prix", 4);

        carrera.save(auto);
        carrera.save(moto);
        carrera.save(moto2);
        carrera.eliminarVehiculo(moto2);

        carrera.darDeAltaAuto(300.0, 100.0, 75.0, "AJK 197");
        carrera.darDeAltaMoto(150.0, 59.7, 34.2, "MOT 069");

        carrera.socorrerAuto("AA12");
        carrera.socorrerMoto("MO32");

        carrera.ganador();

    }
}
