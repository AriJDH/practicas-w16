package ejercicio_lambda;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private static int id;
    private static int ultimoId;
    private List<Vehiculo> vehiculos;

    public Garage(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Garage() {
       vehiculos = new ArrayList<>();
    }



    public static int getId() {
        return id;
    }


    public static void setId(int id) {
        Garage.id = id;
    }

    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Garage.ultimoId = ultimoId;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
