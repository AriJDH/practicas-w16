package dakar;

public class Auto extends Vehiculo{


    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        super.setPeso(3000);
        super.setRuedas(4);
    }
}
