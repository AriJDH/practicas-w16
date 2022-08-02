package Ejercicio1;

import java.util.List;

public class Garaje {
    private static int ContadorGaraje = 0;
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(List<Vehiculo> vehiculos) {
        id =++ContadorGaraje;
        this.vehiculos = vehiculos;
    }

    public static void setContadorGaraje(int contadorGaraje) {
        ContadorGaraje = contadorGaraje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getvehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
