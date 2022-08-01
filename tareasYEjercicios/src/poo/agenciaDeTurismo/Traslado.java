package poo.agenciaDeTurismo;

public class Traslado implements Reservable {

    private static final double PRECIO = 8000;
    private int cantidadDePersonas;

    public Traslado(int cantidadDePersonas) {
        this.cantidadDePersonas = cantidadDePersonas;
    }

    @Override
    public void reservar() {
        System.out.println("Traslado reservado para " + this.cantidadDePersonas + " persona/s");
    }

    @Override
    public String tipoReserva() {
        return "TRASLADO" ;
    }

    @Override
    public double getPrecio() {
        return cantidadDePersonas * PRECIO;
    }

    @Override
    public String toString() {
        return "\nTraslado: " +
                "Cantidad De Personas=" + cantidadDePersonas;
    }
}
