package Ejercicio5.clases;


public class NaveSimple extends Composite {
    private String nombre;
    private Coordenada coordenada;

    public NaveSimple(String nombre, float puntuacion, Coordenada coordenada) {
        this.nombre = nombre;
        this.coordenada = coordenada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public double calcularDistancia(Coordenada coordenadaObjetivo) {
        double distancia = Math.sqrt(
                Math.pow((double)this.coordenada.getX()
                        - (double)coordenadaObjetivo.getX(), 2)
                        + Math.pow((double)this.coordenada.getY()
                        - (double)coordenadaObjetivo.getY(), 2));
        return distancia;
    }
}
