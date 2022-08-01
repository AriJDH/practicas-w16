import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Auto auto1 = new Auto(180,12,8, "12k2l");
        Auto auto2 = new Auto(200,19,7, "9ak3p");
        Moto moto1 = new Moto(120,15,10, "w453p");
        Moto moto2 = new Moto(150,11,11, "8ia3p");

        SocorristaAuto socorristaAuto = new SocorristaAuto();
        SocorristaMoto socorristaMoto = new SocorristaMoto();

        List<Vehiculo> vehiculosIngresantes = new ArrayList<>();

        Carrera carreraOficial = new Carrera(10000,900,"Datak1", 4,vehiculosIngresantes, socorristaAuto,socorristaMoto);
        carreraOficial.darDeAltaAuto(auto1.getVelocidad(),auto1.getAceleración(),auto1.getAnguloDeGiro(),auto1.getPatente());
        carreraOficial.darDeAltaAuto(auto2.getVelocidad(),auto2.getAceleración(),auto2.getAnguloDeGiro(),auto2.getPatente());
        carreraOficial.darDeAltaMoto(moto1.getVelocidad(),moto1.getAceleración(),moto1.getAnguloDeGiro(),moto1.getPatente());
        carreraOficial.darDeAltaMoto(moto2.getVelocidad(),moto2.getAceleración(),moto2.getAnguloDeGiro(),moto2.getPatente());

        carreraOficial.eliminarVehiculo(auto2);
        //carreraOficial.eliminarVehiculoConPatente(moto1.getPatente());

        System.out.println("Cantidad vehiculos:" + carreraOficial.getVehiculos().size());

        System.out.println("Vehiculos permitidos:" + carreraOficial.getCantidadDeVehiculosPermitidos());

        System.out.println("Carrera:" + carreraOficial.toString());

        System.out.println("EL vehiculo ganador:" + carreraOficial.ganardor().toString());

        carreraOficial.socorrerAuto(auto1.getPatente());
        carreraOficial.socorrerMoto(moto2.getPatente());

    }
}
