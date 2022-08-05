package naves;

public class Coordenada {
    private Integer coordenada_x;
    private Integer coordenada_y;

    public Integer getCoordenada_x() {
        return coordenada_x;
    }

    public void setCoordenada_x(Integer coordenada_x) {
        this.coordenada_x = coordenada_x;
    }

    public Integer getCoordenada_y() {
        return coordenada_y;
    }

    public void setCoordenada_y(Integer coordenada_y) {
        this.coordenada_y = coordenada_y;
    }

    public Coordenada(Integer coordenada_x, Integer coordenada_y) {
        this.coordenada_x = coordenada_x;
        this.coordenada_y = coordenada_y;
    }

    @Override
    public String toString() {
        return "Coordenadas{" +
                "coordenada_x=" + coordenada_x +
                ", coordenada_y=" + coordenada_y +
                '}';
    }
}
