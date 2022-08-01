package EjerciciosIntegradoresP2.Dakar.actors;

public class SocorristaAuto extends Auto implements Socorrista<Auto> {

    public SocorristaAuto(double aceleracion, double velocidad, double anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente);
    }

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo Auto. Patente: " + vehiculo.getPatente());
    }
    
}
