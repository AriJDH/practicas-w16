package integradores.integrador2.dakar;

public class SocorristaAuto extends Auto implements Socorrista<Auto> {


    public SocorristaAuto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
    }

    @Override
    public void socorrer(Auto v) {
        System.out.println("Socorriendo auto = " + v.getPatente());
    }
}
