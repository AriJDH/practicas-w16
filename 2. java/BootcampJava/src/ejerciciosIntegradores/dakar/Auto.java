package ejerciciosIntegradores.dakar;

public class Auto extends Vehiculo{
    public Auto(){

    }
    public Auto(Integer velocidad, Float aceleracion, Float anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000f, 4);
    }
}
