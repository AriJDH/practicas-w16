package eip2vivo.Dakar;

public class Autos extends Vehiculo{



    public Autos(Integer velocidad, Integer aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.setPeso(1000);
        this.setRuedas(4);
    }


}
