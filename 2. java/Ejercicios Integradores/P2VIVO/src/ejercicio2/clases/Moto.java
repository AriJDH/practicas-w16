package ejercicio2.clases;

public class Moto extends Vehiculo{
    public Moto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }

    @Override
    public String toString() {
        return "\nMoto: \n" + super.toString();
    }
}
