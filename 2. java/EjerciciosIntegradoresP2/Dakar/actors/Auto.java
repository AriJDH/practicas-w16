package EjerciciosIntegradoresP2.Dakar.actors;

public class Auto extends Vehiculo {

    private final static int cantidadDeRuedas = 3;
    private final static double peso = 1000;

    public Auto(double aceleracion, double velocidad, double anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente, peso, cantidadDeRuedas);
    }
}
