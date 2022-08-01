public class Meteorito {
    private int coordenada_x;
    private int coordenada_y;

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

    @Override
    public String toString() {
        return "Meteorito{" +
                "coordenada_x=" + coordenada_x +
                ", coordenada_y=" + coordenada_y +
                '}';
    }

    public Meteorito(int coordenada_x, int coordenada_y) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
    }
}
