package RecapituladoJava;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addVehiculos(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
