package ejercicio2;

public class Nave {
    private  String nombre;
    private int corrdenadaX;
    private int coordenadaY;
    private double puntuacion = 0;

    public String getNombre() {return nombre;}

    public Nave(String nombre, int corrdenadaX, int coordenadaY) {
        this.nombre = nombre;
        this.corrdenadaX = corrdenadaX;
        this.coordenadaY = coordenadaY;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCorrdenadaX() {
        return corrdenadaX;
    }

    public void setCorrdenadaX(int corrdenadaX) {
        this.corrdenadaX = corrdenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
