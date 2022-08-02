package eip2vivo.Dakar;

public class SoccoristaAuto extends Vehiculo{

    public SoccoristaAuto(Integer velocidad, Integer aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    public void socorrer(Autos unAuto) {
        System.out.println("Socorriendo auto: Patente " + unAuto.getPatente());
    }
}
