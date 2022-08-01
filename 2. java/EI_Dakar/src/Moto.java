public class Moto extends Vehiculo{
    private static final Double PESO = 300.0;
    private static final int RUEDAS = 2;

    public Moto(Double unaVelocidad, Double unaAceleracion, Double unAnguloDeGiro, String unaPatente) {
        super(unaVelocidad, unaAceleracion, unAnguloDeGiro, unaPatente, PESO, RUEDAS);
    }

    public Moto() {
    }

}
