package practica.ejerciciosintegradores.p2.dakar;

public class Auto extends Vehiculo {

    protected static double peso = 300;
    protected static int ruedas = 2;
    public Auto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public Auto() {}
}
