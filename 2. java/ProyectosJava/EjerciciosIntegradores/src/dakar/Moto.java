package dakar;

public class Moto extends Vehiculo{


    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.setPeso(1000);
        super.setRuedas(4);
    }
}
