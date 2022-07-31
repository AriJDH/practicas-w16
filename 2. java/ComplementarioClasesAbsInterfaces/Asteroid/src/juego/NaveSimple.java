package juego;

import juego.interfaces.Naves;

public class NaveSimple implements Naves {
    private String nombre;
    private int coorX;
    private int coorY;
    private static double puntuacion = 0;

    public NaveSimple(String nombre, int coorX, int coorY) {
        this.nombre = nombre;
        this.coorX = coorX;
        this.coorY = coorY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoorX() {
        return coorX;
    }

    public void setCoorX(int coorX) {
        this.coorX = coorX;
    }

    public int getCoorY() {
        return coorY;
    }

    public void setCoorY(int coorY) {
        this.coorY = coorY;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public double calcularDistancia(int x2, int y2){
        double distancia = Math.sqrt(Math.pow((this.coorX-x2),2)+Math.pow((this.coorY-y2),2));

        return distancia;
    }
}
