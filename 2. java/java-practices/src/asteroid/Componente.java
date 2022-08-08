package asteroid;

public abstract class Componente {
    protected int puntuacion;

    public Componente(){
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
