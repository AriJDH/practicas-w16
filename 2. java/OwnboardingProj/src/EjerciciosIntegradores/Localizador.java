package EjerciciosIntegradores;

import java.util.List;

public class Localizador {
    private List<Reserva> reservas;
    private Cliente cliente;
    private Double total;

    public Localizador(List<Reserva> reservas, Cliente cliente) {
        this.reservas = reservas;
        this.cliente = cliente;
        this.total = reservas.stream().mapToDouble(x -> x.getCosto()).sum();
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
