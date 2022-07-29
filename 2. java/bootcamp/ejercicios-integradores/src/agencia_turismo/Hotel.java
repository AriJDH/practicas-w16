package agencia_turismo;

public class Hotel extends Reserva{
    public Hotel(Double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Hotel: $" + precio;
    }
}
