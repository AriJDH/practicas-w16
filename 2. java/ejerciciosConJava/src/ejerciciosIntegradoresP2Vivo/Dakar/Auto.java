package ejerciciosIntegradoresP2Vivo.Dakar;

public class Auto extends Vehiculo{

    private static final double PESO =1000;
    private static final int RUEDAS =4;
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);

    }

    @Override
    public String toString() {
        return "Auto"+super.toString();
    }
}
