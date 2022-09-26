package Vehiculos;

import java.util.List;

public class Garaje {
    private Integer id;
    private List<Vehiculo> vehiculos;

    public Garaje(Integer id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public Integer getId() { return id; }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setId(Integer id) {  this.id = id;}

    public void setVehiculos(List<Vehiculo> vehiculos) {this.vehiculos = vehiculos;}

}
