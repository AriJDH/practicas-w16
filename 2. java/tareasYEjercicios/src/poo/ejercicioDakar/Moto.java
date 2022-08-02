package poo.ejercicioDakar;

public class Moto extends Vehiculo {
    private static final double PESO = 300;
    private static final int RUEDAS = 2;

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

    @Override
    public String toString() {
        return "\nMoto " + super.toString();
    }
}
