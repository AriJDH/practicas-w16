package Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private List<Vehiculo> vehiculos = new ArrayList<>();
    private int id;

    public Garage(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void agregarVehiculos(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
}
