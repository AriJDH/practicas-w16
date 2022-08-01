package EjerciciosIntegradoresP2.Dakar.actors;

public class Moto extends Vehiculo {

    private final static int cantidadDeRuedas = 2;
    private final static double peso = 300;

    public Moto(double aceleracion, double velocidad, double anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente, peso, cantidadDeRuedas);
    }

    @Override
    public String toString() {
        return "Moto{" + "patente=" + patente + ", aceleracion=" + aceleracion + ", velocidad=" + velocidad + ", anguloDeGiro=" + anguloDeGiro + '}';
    }
}
