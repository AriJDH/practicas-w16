package ejercicio5.clases;

import ejercicio5.interfaces.Nave;

public class NaveSimple implements Nave {
    private String nombre;
    private Coordenada coordenadas;

    private int puntuacion = 0;

    public Coordenada getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(Coordenada coordenadas) {
        this.coordenadas = coordenadas;
    }

    public NaveSimple(String nombre, Coordenada coordenadas) {
        this.nombre = nombre;
        this.coordenadas = coordenadas;
    }

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", x=" + coordenadas.getX() +
                ", y=" + coordenadas.getY() +
                ", puntuacion=" + puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public double calcularDistancia(double x, double y){
        double distancia = Math.sqrt(Math.pow((x*1)-(x*2),2)+Math.pow((y*1)-(y*2),2));
        return distancia;
    }
}
