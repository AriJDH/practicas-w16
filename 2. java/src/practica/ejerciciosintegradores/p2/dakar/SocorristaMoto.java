package practica.ejerciciosintegradores.p2.dakar;

public class SocorristaMoto extends Moto implements Socorrista<Moto> {

    protected Moto moto;

    public SocorristaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Soccoriendo moto: " + moto.getPatente());
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }
}
