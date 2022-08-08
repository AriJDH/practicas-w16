package recapitulando;

import java.util.List;
import java.util.OptionalDouble;

public class Garaje {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public double promedio(){
        return this.vehiculos.stream()
                .mapToDouble(vehiculo -> vehiculo.getCosto())
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
