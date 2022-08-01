package dakar;

public class Moto extends Vehiculo{
    private static final int pesoAuto = 300;
    private static final int ruedas = 2;

    public Moto() {
    }

    public Moto(int velucidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velucidad, aceleracion, anguloDeGiro, patente, pesoAuto, ruedas);
    }

    public String toString() {
        return "Moto{ " +super.toString();
    }
}
