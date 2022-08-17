package ejercicio1;

import java.util.List;

public class Garage {
    private int  idUnico;
    private List<Vehiculo> vehiculos;

    public Garage(int idUnico, List<Vehiculo> vehiculos) {
        this.idUnico = idUnico;
        this.vehiculos = vehiculos;
    }

    public int getIdUnico() {
        return idUnico;
    }

    public void setIdUnico(int idUnico) {
        this.idUnico = idUnico;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "idUnico=" + idUnico +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
