package naves;

public class NaveSimple extends Nave{

    private String nombre;
    Coordenada coordenada;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NaveSimple(String nombre, Coordenada coordenada) {
        this.nombre = nombre;
        this.coordenada = coordenada;
    }

    @Override
    public Double calcularDistancia(int meteorito_coordenada_x, int meteorito_coordenada_y) {
        int x = this.coordenada.getCoordenada_x();
        int y = this.coordenada.getCoordenada_y();

        Double distancia = 0.0;

        distancia = Math.sqrt(Math.pow(Double.valueOf(meteorito_coordenada_x-x),2) + (Math.pow(Double.valueOf(meteorito_coordenada_y-y),2)));
        return distancia;
    }


    //double distancia = Math.sqrt(Math.pow((double)this.coordenada.getX() - (double)coordenadaObjetivo.getX(), 2) + Math.pow((double)this.coordenada.getY() - (double)coordenadaObjetivo.getY(), 2));
    //    return distancia;
}
