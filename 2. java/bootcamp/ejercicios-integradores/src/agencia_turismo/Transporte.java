package agencia_turismo;

public class Transporte extends Reserva{
    public Transporte(Double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Transporte: $" + precio;
    }
}
