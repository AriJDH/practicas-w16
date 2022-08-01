import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto(100,10,45,"auto1");
        Moto moto = new Moto(10,5,45,"moto1");
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(moto);
        Carrera carrera = new Carrera(1.0,100,"Carrera1",10,vehiculos);
        Auto auto2 = new Auto(50,10,45,"auto2");
        carrera.darDeAltaAuto(50,10,45,"auto2");
        carrera.darDeAltaMoto(15,5,45,"moto2");
        carrera.eliminarVehiculo(auto2);
        SocorristaMoto socorristaMoto = new SocorristaMoto();
        SocorristaAuto socorristaAuto = new SocorristaAuto();
        carrera.setSocorristaMoto(socorristaMoto);
        carrera.setSocorristaAuto(socorristaAuto);
        carrera.socorrerAuto("auto1");
        carrera.socorrerMoto("moto1");
        carrera.eliminarVehiculoConPatente("moto2");
        Vehiculo ganador = carrera.determinarGanador();
        System.out.println("El ganador de la carrera fue: "+ ganador.toString());
    }
}
