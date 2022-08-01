import java.util.ArrayList;

public class Garaje {
    private static int id;
    private ArrayList<Vehiculo> listaVehiculos;

    public Garaje(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Garaje.id = id;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }
}
