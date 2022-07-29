package EjercicioClase;
import java.util.*;
public class Garaje {
    private long id;
    private List<Vehiculo> listaVehiculo;

    public Garaje(long id) {
        this.id = id;
        this.listaVehiculo = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }

    public void setListaVehiculo(List<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", listaVehiculo=" + listaVehiculo +
                '}';
    }
}
