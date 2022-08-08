package asteroid;

import java.util.List;

public class FlotaDeNaves extends Componente { // Composite
    private List<Componente> listaDeNaves;

    public FlotaDeNaves(List<Componente> listaDeNaves){
        super();
        this.listaDeNaves = listaDeNaves;
    }

    public List<Componente> getListaDeNaves() {
        return this.listaDeNaves;
    }

    public void setListaDeNaves(List<Componente> listaDeNaves) {
        this.listaDeNaves = listaDeNaves;
    }

    @Override
    public double calcularDistancia(Coordenada coordenadaObjetivo) {
        double sumaDeDistancias = 0;
        for(Componente nave: this.listaDeNaves){
            sumaDeDistancias += nave.calcularDistancia(coordenadaObjetivo);
        }
        double distanciaPromedio = sumaDeDistancias / this.listaDeNaves.size();

        return distanciaPromedio;
    }
}
