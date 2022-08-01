package ejercicio2.clases;

public class Auto extends Vehiculo{
    public Auto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    @Override
    public String toString() {
        return "\nAuto: \n" + super.toString();
    }
}
