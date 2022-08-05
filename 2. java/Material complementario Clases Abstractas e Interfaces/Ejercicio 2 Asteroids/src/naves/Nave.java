package naves;

public abstract class Nave {
    private int puntuacion_inicial = 0;

    public int getPuntuacion_inicial() {
        return puntuacion_inicial;
    }

    public void setPuntuacion_inicial(int puntuacion_inicial) {
        this.puntuacion_inicial = 0 + puntuacion_inicial;
    }

    public abstract Double calcularDistancia(int meteorito_coordenada_x, int meteorito_coordenada_y);

}
