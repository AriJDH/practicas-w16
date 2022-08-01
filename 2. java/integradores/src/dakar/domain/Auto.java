package dakar.domain;

public class Auto extends Vehiculo{
    public Auto(int velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }
}
