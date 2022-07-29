package vehiculos;

import java.util.List;

public class Garage {
    private final List<Vehiculo> vehiculos;

    public Garage(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}
