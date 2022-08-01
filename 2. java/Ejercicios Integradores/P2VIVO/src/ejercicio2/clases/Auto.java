package ejercicio2.clases;

public class Auto extends Vehiculo{
    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    @Override
    public String toString() {
        return "\nAuto: \n" + super.toString();
    }
}
