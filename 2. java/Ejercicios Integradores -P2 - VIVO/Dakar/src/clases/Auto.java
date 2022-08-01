package clases;

public class Auto extends Vehiculo{

    public Auto() {
    }

    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000.0, 4);
    }
}

