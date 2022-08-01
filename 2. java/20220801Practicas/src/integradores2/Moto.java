package integradores2;

public class Moto extends Vehiculo{

    public Moto(float velocidad, float aceleracion, int anguloGiro, String patente) {
        super(velocidad, aceleracion, anguloGiro, patente, 300,2);
    }

    @Override
    public String toString() {
        return "Auto{" +super.toString() +"}";
    }
}
