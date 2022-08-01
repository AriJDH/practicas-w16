package Lambda_Streams;

import java.util.List;

public class Garage {

    private List<Vehiculo> vehiculos;
    private Integer id;

    public Garage() {}

    public Garage(List<Vehiculo> vehiculos, Integer id) {
        this.vehiculos = vehiculos;
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "vehiculos=" + vehiculos +
                ", id=" + id +
                '}';
    }
}
