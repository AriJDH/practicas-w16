package poo.ejercicioDakar;

public class SocorristaMoto extends Vehiculo {

    private static final double PESO = 300;
    private static final int RUEDAS = 2;

    public SocorristaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO, RUEDAS);
    }

    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto con patente " + moto.getPatente());
    }
}
