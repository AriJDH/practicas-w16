package poo.ejercicioDakar;

public class SocorristaAuto extends Vehiculo {

    private static final double PESO = 1000;
    private static final int RUEDAS = 4;

    public SocorristaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto con patente " + auto.getPatente());
    }
    
}
