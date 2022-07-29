package Entity;

public abstract class Reserva {
    protected Double costo;

    public Reserva(Double costo) {
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }
}
