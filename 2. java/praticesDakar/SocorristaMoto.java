package praticesDakar;

public class SocorristaMoto extends Moto implements ISocorrista<Moto> {

    public SocorristaMoto() {
    }

    public SocorristaMoto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public void socorrer(Moto object) {
        System.out.println("Socorriendo moto: " + object.getPatente());
    }
}
