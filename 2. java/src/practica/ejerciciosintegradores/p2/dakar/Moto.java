package practica.ejerciciosintegradores.p2.dakar;

public class Moto extends Vehiculo {

    protected static double peso = 1000;
    protected static int ruedas = 4;

    public Moto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public Moto() {}

}
