package integradores2;

public class Auto extends Vehiculo{

    public Auto(float velocidad, float aceleracion, int anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, 1000,4);
    }

    @Override
    public String toString() {
        return "Auto{" +super.toString() +"}";
    }
}
