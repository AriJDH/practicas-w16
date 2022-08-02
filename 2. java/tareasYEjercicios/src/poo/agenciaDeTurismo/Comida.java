package poo.agenciaDeTurismo;

public class Comida implements Reservable {

    private boolean dosComidas;
    private static final double PRECIO_POR_COMIDA = 2500;
    private int cantPersonas;

    public Comida(boolean dosComidas, int cantPersonas) {
        this.dosComidas = dosComidas;
        this.cantPersonas = cantPersonas;
    }

    public boolean isDosComidas() {
        return dosComidas;
    }

    public void setDosComidas(boolean dosComidas) {
        this.dosComidas = dosComidas;
    }

    @Override
    public String toString() {
        return "\nComida: " +
                "Dos Comidas:" + dosComidas +
                ", Cantidad de Personas: " + cantPersonas;
    }

    @Override
    public void reservar() {
        System.out.println("Reservo Almuerzo/Cena para  " + this.cantPersonas + " persona/s");
    }

    @Override
    public String tipoReserva() {
        return "COMIDA" ;
    }

    @Override
    public double getPrecio() {
        return this.cantPersonas * PRECIO_POR_COMIDA * 2;
    }
}
