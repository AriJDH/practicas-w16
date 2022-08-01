package Automotora;

import java.util.List;

public class Garage {
    private int id;

    public Garage(int id, List<Vehiculo> lstVehiculo) {
        this.id = id;
        LstVehiculo = lstVehiculo;
    }

    private List<Vehiculo> LstVehiculo;

    public Garage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getLstVehiculo() {
        return LstVehiculo;
    }

    public void setLstVehiculo(List<Vehiculo> lstVehiculo) {
        LstVehiculo = lstVehiculo;
    }
}
