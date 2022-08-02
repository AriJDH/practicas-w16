package poo.ejercicioDakar;

public class Auto extends Vehiculo {
    private static final double PESO = 1000;
    private static final int RUEDAS = 4;

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

    @Override
    public String toString() {
        return "\nAuto " + super.toString();
    }
}
