public abstract class Reserva {
    Double costo;

    public Reserva(Double costo) {
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "costo=" + costo +
                '}';
    }
}
