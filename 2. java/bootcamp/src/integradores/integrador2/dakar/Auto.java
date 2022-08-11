package integradores.integrador2.dakar;

public class Auto extends Vehiculo{

    private static final int peso = 1000;
    private static final int ruedas = 4;

    public Auto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public int getPeso() {
        return peso;
    }

    @Override
    public int getCantRuedas() {
        return ruedas;
    }
}
