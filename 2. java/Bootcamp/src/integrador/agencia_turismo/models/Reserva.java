package integrador.agencia_turismo.models;

public abstract class Reserva {

    protected Double precio;

    public Reserva(Double precio) {
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
