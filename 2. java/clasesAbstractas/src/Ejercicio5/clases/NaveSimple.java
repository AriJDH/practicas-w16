package Ejercicio5.clases;

import Ejercicio5.interfaces.INaveDistancia;

public class NaveSimple implements INaveDistancia {
    private String nombre;
    private float puntuacion=0;
    private Coordenada coordenada;

    public NaveSimple(String nombre, float puntuacion, Coordenada coordenada) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.coordenada = coordenada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public double calcularDistancia(Double x, Double y) {
        double resultado = Math.sqrt(Math.pow(x*1 - x*2, 2) + Math.pow(y*1 - y*2, 2));
        return resultado;
    }
}
