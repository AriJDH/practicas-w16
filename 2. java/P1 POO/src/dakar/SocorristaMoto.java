package dakar;

public class SocorristaMoto extends Moto implements Socorrista<Moto> {

    public SocorristaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto = " + vehiculo.getPatente());
    }
}
