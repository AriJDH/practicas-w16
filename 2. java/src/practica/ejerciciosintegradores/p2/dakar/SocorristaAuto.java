package practica.ejerciciosintegradores.p2.dakar;

public class SocorristaAuto extends Auto implements Socorrista<Auto> {

    protected Auto auto;

    public SocorristaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto: " + auto.getPatente());
    }

    public Auto getAuto() {
        return auto;
    }

    public void setAuto(Auto auto) {
        this.auto = auto;
    }
}
