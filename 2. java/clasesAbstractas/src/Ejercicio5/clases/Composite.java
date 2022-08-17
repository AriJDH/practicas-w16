package Ejercicio5.clases;

public abstract class Composite {
    protected int puntuacion;

    public Composite(){
        this.puntuacion = 0;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public abstract double calcularDistancia(Coordenada coordenadaObjetivo);
}

