package Dakar;

public class Auto extends Vehiculo{
    public Auto() {
    }

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.setPeso(1000.0);
        super.setRuedas(4);
    }
}
