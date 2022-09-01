package ejerciciosIntegradoresP2Vivo.Dakar;

public class Moto extends Vehiculo{

    public static final double PESO = 300;
    public static final int RUEDAS = 2;


    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

    @Override
    public String toString() {
        return "Moto"+super.toString();
    }
}
