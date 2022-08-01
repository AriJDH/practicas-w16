package naves;

public class Nave_simple extends Nave{
    public Nave_simple(String nombre, int coordenada_x, int coordenada_y) {
        super(nombre, coordenada_x, coordenada_y);
    }

    @Override
    public Double calcularDistancia(int meteorito_coordenada_x, int meteorito_coordenada_y) {
        int x = this.getCoordenada_x();
        int y = this.getCoordenada_y();

        Double distancia = 0.0;

        distancia = Math.sqrt(Math.pow(Double.valueOf(meteorito_coordenada_x-x),2) + (Math.pow(Double.valueOf(meteorito_coordenada_y-y),2)));
        return distancia;
    }
}
