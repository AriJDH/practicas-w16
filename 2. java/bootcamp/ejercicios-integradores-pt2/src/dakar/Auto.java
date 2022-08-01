package dakar;

public class Auto extends Vehiculo{

    private static final int CANTIDAD_RUEDAS = 4;
    private static final double PESO = 1000;


    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, CANTIDAD_RUEDAS);
    }
}
