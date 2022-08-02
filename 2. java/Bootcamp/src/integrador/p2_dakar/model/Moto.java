package integrador.p2_dakar.model;

public class Moto extends Vehiculo{

    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300.0, 2);
    }

    @Override
    public String toString() {
        return String.format("Moto - %s\n",super.toString());
    }

}
