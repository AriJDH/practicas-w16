public class Motos extends Vehiculo{
    private static final double PESO = 300;
    private static final int RUEDAS = 2;

    public Motos(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,PESO,RUEDAS);
    }

    public Motos() {
    }

    @Override
    public String toString() {
        return "Motos{ " + super.toString() + " }";
    }
}
