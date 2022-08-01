package naves;

public abstract class Nave {
    private String nombre;
    private int coordenada_x;
    private int coordenada_y;
    private int puntuacion_inicial = 0;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(int coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public int getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(int coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public int getPuntuacion_inicial() {
        return puntuacion_inicial;
    }

    public void setPuntuacion_inicial(int puntuacion_inicial) {
        this.puntuacion_inicial = puntuacion_inicial;
    }

    public Nave(String nombre, int coordenada_x, int coordenada_y) {
        this.nombre = nombre;
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
    }

    @Override
    public String toString() {
        return "Nave{" +
                "nombre='" + nombre + '\'' +
                ", coordenada_x=" + coordenada_x +
                ", coordenada_y=" + coordenada_y +
                '}';
    }

    public abstract Double calcularDistancia(int meteorito_coordenada_x, int meteorito_coordenada_y);

}
