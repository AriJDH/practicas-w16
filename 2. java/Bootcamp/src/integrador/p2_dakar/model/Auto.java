package integrador.p2_dakar.model;

public class Auto extends Vehiculo{

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000.0, 4);
    }

    @Override
    public String toString() {
        return String.format("Auto - %s\n",super.toString());
    }
}
