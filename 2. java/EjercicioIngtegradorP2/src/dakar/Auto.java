package dakar;

public class Auto extends Vehiculo{
    private static final int pesoAuto = 1000;
    private static final int ruedas = 4;

    public Auto() {
    }

    public Auto(int velucidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velucidad, aceleracion, anguloDeGiro, patente, pesoAuto, ruedas);
    }

    @Override
    public String toString() {
        return "Auto{ " +super.toString();
    }
}
