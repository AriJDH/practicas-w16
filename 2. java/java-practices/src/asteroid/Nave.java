package asteroid;

public class Nave extends Componente {
    private String nombre;
    private Coordenada coordenada;

    public Nave(String nombre, Coordenada coordenada){
        super();
        this.nombre = nombre;
        this.coordenada = coordenada;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Coordenada getCoordenada() {
        return this.coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    @Override
    public double calcularDistancia(Coordenada coordenadaObjetivo){
        double distancia = Math.sqrt(Math.pow((double)this.coordenada.getX() - (double)coordenadaObjetivo.getX(), 2) + Math.pow((double)this.coordenada.getY() - (double)coordenadaObjetivo.getY(), 2));
        return distancia;
    }
}
