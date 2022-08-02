package eip2vivo.Dakar;

public class Motos extends Vehiculo{

    public Motos(Integer velocidad, Integer aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.setPeso(300);
        this.setRuedas(2);
    }


}
