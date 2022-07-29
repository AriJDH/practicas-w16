package ExerciseOne.actors;

import java.util.List;
import java.util.ArrayList;

public class Garaje {
    private String ID;
    private List<Vehiculo> vehiculos;
    
    public Garaje(String ID) {
        this.ID = ID;
        this.vehiculos = new ArrayList<Vehiculo>();
    }

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void addVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }

    public void removeVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }

}
