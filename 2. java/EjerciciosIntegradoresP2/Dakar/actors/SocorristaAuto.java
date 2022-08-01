package EjerciciosIntegradoresP2.Dakar.actors;

public class SocorristaAuto extends Vehiculo implements Socorrista<Auto> {

    private final static int cantidadDeRuedas = 4;
    private final static double peso = 1000;

    public SocorristaAuto(double aceleracion, double velocidad, double anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente, peso, cantidadDeRuedas);
    }

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo Auto. Patente: " + vehiculo.getPatente());
    }
    
}
