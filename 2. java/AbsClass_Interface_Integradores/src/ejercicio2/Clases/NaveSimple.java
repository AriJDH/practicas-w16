package ejercicio2.Clases;

import ejercicio2.Interfaces.Nave;

public class NaveSimple implements Nave {

    private String nombre;
    private int x,y;

    public NaveSimple(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Double destruirAsteroide(Asteroide asteroid) {
        return Math.sqrt(Math.pow(getX() - asteroid.getPosx(), 2) + Math.pow(getY() - asteroid.getPosy(), 2));
    }
}
