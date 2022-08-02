package integrador.p2_dakar.model;

import integrador.p2_dakar.interfaces.ISocorrer;

public class SocorristaMoto extends Vehiculo implements ISocorrer<Moto> {
    public SocorristaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas) {
        super(velocidad, aceleracion, anguloDeGiro, patente, peso, ruedas);
    }

    public void socorrer(Moto unaMoto){
        System.out.printf("Socorriendo moto: %s\n", unaMoto.getPatente());
    }

}
