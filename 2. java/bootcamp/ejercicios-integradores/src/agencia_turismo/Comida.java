package agencia_turismo;

public class Comida extends Reserva{
    public Comida(Double precio) {
        super(precio);
    }

    @Override
    public String toString() {
        return "Comida: $"+ precio;
    }
}
