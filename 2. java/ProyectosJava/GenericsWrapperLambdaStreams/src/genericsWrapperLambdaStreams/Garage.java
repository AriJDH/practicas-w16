package genericsWrapperLambdaStreams;

import java.util.List;

public class Garage {

    private double id;
    private List<Vehiculo> listaDeVeiculos;

    public Garage() {
    }

    public Garage(double id, List<Vehiculo> listaDeVeiculos) {
        this.id = id;
        this.listaDeVeiculos = listaDeVeiculos;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public List<Vehiculo> getListaDeVeiculos() {
        return listaDeVeiculos;
    }

    public void setListaDeVeiculos(List<Vehiculo> listaDeVeiculos) {
        this.listaDeVeiculos = listaDeVeiculos;
    }
}
