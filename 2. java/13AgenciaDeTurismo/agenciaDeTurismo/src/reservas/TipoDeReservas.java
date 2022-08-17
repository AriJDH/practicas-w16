package reservas;

public class TipoDeReservas {
    private String tipoDeReserva;

    public TipoDeReservas(String tipoDeReserva) {
        this.tipoDeReserva = tipoDeReserva;
    }

    @Override
    public String toString() {
        return "TipoDeReservas{" +
                "tipoDeReserva='" + tipoDeReserva + '\'' +
                '}';
    }
}
