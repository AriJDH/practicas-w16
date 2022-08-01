import java.util.List;

public class Localizador {

    private Cliente comprador;
    private double montoTotal;
    private List<Reserva> reservas;
    private Agencia_Turismo agencia;

    public Localizador(Cliente comprador, List<Reserva> reservas, Agencia_Turismo agencia) {
        this.comprador = comprador;
        this.reservas = reservas;
        this.agencia = agencia;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReserva(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Agencia_Turismo getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia_Turismo agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "comprador = " + comprador + "\n" +
                "montoTotal = " + montoTotal + "\n" +
                "reserva = " + reservas + "\n" +
                "agencia = " + agencia + "\n";
    }

    public void costoTotalReservaCalculadora(){
        double total = 0;
        for (Reserva reserva : this.reservas) {
            total = total + reserva.getMonto();
        }
        this.montoTotal = total;
    }
}
