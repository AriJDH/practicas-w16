package agenciaDeViaje;

import java.util.List;

public class Localizador {
    private List<Reserva> listaReserva;
    private double total;
    private Cliente cliente;


    public Localizador(List<Reserva> listaReserva, Cliente cliente) {
        this.listaReserva = listaReserva;
        this.total = total;
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "listaReserva=" + listaReserva +
                ", total=" + total +
                ", cliente=" + cliente +
                '}';
    }

    public List<Reserva> getListaReserva() {
        return listaReserva;
    }

    public void setListaReserva(List<Reserva> listaReserva) {
        this.listaReserva = listaReserva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
