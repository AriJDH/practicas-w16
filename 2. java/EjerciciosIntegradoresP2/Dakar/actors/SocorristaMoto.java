package EjerciciosIntegradoresP2.Dakar.actors;

public class SocorristaMoto extends Moto implements Socorrista<Moto> {

    public SocorristaMoto(double aceleracion, double velocidad, double anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente);
    }

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo Moto. Patente: " + vehiculo.getPatente());
    }
    
}
