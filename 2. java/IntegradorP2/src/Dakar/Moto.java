package Dakar;

public class Moto extends Vehiculo{
    public Moto() {
    }

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.setPeso(300.0);
        super.setRuedas(2);
    }
}