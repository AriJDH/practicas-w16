package integrador.p2_dakar.model;

import integrador.p2_dakar.interfaces.ISocorrer;

public class SocorristaAuto extends Vehiculo implements ISocorrer<Auto> {
    public SocorristaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Auto unAuto){
        System.out.printf("Socorriendo auto: %s\n", unAuto.getPatente());
    }
}
