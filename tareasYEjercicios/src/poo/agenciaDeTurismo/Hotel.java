package poo.agenciaDeTurismo;

public class Hotel implements Reservable {

    private String nombre;
    private static final double PRECIO_POR_DIA = 4000;
    private int cantDias;
    private int cantPersonas;

    public Hotel(String nombre, int cantDias, int cantPersonas) {
        this.nombre = nombre;
        this.cantDias = cantDias;
        this.cantPersonas = cantPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    @Override
    public void reservar() {
        System.out.println("Hotel " + this.nombre + " ha sido reservado ");
    }

    @Override
    public String tipoReserva() {
        return "HOTEL" ;
    }

    @Override
    public double getPrecio() {
        return PRECIO_POR_DIA * cantDias;
    }

    @Override
    public String toString() {
        return "\nHotel " +
                "Nombre: " + nombre +
                ", cantDias: " + cantDias +
                ", cantPersonas: " + cantPersonas;
    }
}
