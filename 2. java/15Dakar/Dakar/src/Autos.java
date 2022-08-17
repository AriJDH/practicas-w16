public class Autos extends Vehiculo{
    private static final double PESO = 1000;
    private static final int RUEDAS = 4;

    public Autos(int velocidad, int aceleracion, int anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente,PESO,RUEDAS);
    }

    public Autos() {
    }

    @Override
    public String toString() {
        return "Autos{ " + super.toString() + " }";
    }
}
