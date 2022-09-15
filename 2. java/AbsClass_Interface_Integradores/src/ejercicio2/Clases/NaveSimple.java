package ejercicio2.Clases;

import ejercicio2.Interface.Nave;

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
    public Double destruirAsteroide() {
        return Math.sqrt(getX() - Math.pow(getX(), 2)) + Math.sqrt(getY() - Math.pow(getY(), 2));
    }
}
