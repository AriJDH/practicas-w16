package vehiculos;

import java.util.ArrayList;
import java.util.List;

public class Garage {

    private int id;
    private List<Vehiculo> listaDeVehiculos;

    public Garage(){
        this.id = 0;
        this.listaDeVehiculos = new ArrayList();
    }

    public Garage(int id, List<Vehiculo> listaDeVehiculos) {
        this.id = id;
        this.listaDeVehiculos = listaDeVehiculos;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaDeVehiculos() {
        return this.listaDeVehiculos;
    }

    public void setListaDeVehiculos(List<Vehiculo> listaDeVehiculos) {
        this.listaDeVehiculos = listaDeVehiculos;
    }
}
