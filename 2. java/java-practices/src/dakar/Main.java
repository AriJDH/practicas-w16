package dakar;

/*
 * Ejercicio > Modulo 5: Java > EjerciciosIntegradores-P2-VIVO
 * ESTADO: Finalizado.
 * @GonzaloNahuelDiPierro
 * */
public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(2000,1000000, "Dakar 2022", 10);

        carrera.darAltaVehiculo( new Auto(100, 100, 20, "1", 1000));
        carrera.darAltaVehiculo( new Auto(50, 80, 40, "2", 1000));
        carrera.darAltaVehiculo( new Auto(70, 120, 70, "3", 1000));
        carrera.darAltaVehiculo( new Moto(90, 150,60, "10", 300));
        carrera.socorrer("10");
        carrera.socorrer("1");

        carrera.eliminarVehiculo(new Moto(90, 150,60, "10", 300));
        //carrera.eliminarVehiculoConPatente("10");

        System.out.println("El ganador es: " + carrera.definirGanador());
    }
}
