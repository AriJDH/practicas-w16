package agencia_turismo;

public class BoletoViaje extends Reserva{
    public BoletoViaje(Double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Boleto Viaje: $" + precio;
    }
}
