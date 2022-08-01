package practico_integrador2.dakar;

public class Moto extends Vehiculo{

    private static final int peso = 300;
    private static final int ruedas = 2;

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
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