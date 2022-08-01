package EjerciciosIntegradoresP2.Dakar.actors;

public class SocorristaMoto extends Vehiculo implements Socorrista<Moto> {

    private final static int cantidadDeRuedas = 2;
    private final static double peso = 300;

    public SocorristaMoto(double aceleracion, double velocidad, double anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente, peso, cantidadDeRuedas);
    }

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo Moto. Patente: " + vehiculo.getPatente());
    }
    
}
