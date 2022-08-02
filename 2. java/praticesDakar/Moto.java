package praticesDakar;

public class Moto extends Vehiculo{

    public Moto() {
    }

    public Moto(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300, 2);
    }
}
