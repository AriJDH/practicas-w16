package praticesDakar;

public class Auto extends Vehiculo {

    public Auto() {
    }

    public Auto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }
}
