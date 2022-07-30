import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private String id;
    private List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();

    public Garaje(String id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
