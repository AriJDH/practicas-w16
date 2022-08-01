public class Auto extends Vehiculo {
    private static final Double PESO = 1000.0;
    private static final int RUEDAS = 4;

    public Auto(Double unaVelocidad, Double unaAceleracion, Double unAnguloDeGiro, String unaPatente) {
        super(unaVelocidad, unaAceleracion, unAnguloDeGiro, unaPatente, PESO, RUEDAS);
    }

    public Auto() {
    }

}

