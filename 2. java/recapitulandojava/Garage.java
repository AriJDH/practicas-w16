package recapitulandojava;

import java.util.List;

public class Garage {
    private Long id;
    private List<Vehiculo> vehiculos;

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", vehiculos=" + vehiculos +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Garage(Long id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Garage() {
    }
}
