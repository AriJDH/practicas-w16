package Ejercicios5;

public class Nave implements Distanciable {
    private String nombre;
    private int puntuacion = 0;
    private int x;
    private int y;

    public Nave(String nombre, int x, int y) {
        this.nombre = nombre;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", puntuacion=" + puntuacion +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public double coordenadaADistancia() {
        var result = Math.sqrt(Math.pow((x*1 - x*2),2) + Math.pow((y*1 - y*2),2)); //sqtr es para sacar la raiz cuadrada
        return result;
    }
}
