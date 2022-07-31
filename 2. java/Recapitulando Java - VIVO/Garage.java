package Ejercicio1;

import java.util.List;


public class Garage {

    static int id = 1;
    private List<Vehiculo> vehiculos;;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id += id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }


    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
